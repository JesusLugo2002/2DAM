package com.docencia.aed.infrastructure.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableConfigurationProperties(AppSecurityProperties.class)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Para el ejercicio: passwords en claro. En producción usar BCryptPasswordEncoder.
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService(AppSecurityProperties props) {
        InMemoryUserDetailsManager mgr = new InMemoryUserDetailsManager();
        for (var u : props.getUsers()) {
            String[] roles = u.getRoles().toArray(new String[0]);
            mgr.createUser(User.withUsername(u.getUsername())
                    .password(u.getPassword())
                    .roles(roles)
                    .build());
        }
        return mgr;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration cfg) throws Exception {
        return cfg.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                          AppSecurityProperties props,
                                          JwtAuthenticationFilter jwtFilter) throws Exception {

        http.csrf(csrf -> csrf.disable());
        http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Rutas públicas/protegidas vienen de configuración externalizada
        http.authorizeHttpRequests(auth -> {
            for (String p : props.getRoutes().getPublic()) {
                auth.requestMatchers(p).permitAll();
            }
            for (String p : props.getRoutes().getProtected()) {
                auth.requestMatchers(p).authenticated();
            }

            // Por defecto: denegar el resto (para que el alumnado sea explícito)
            auth.anyRequest().denyAll();
        });

        // Añadimos el filtro JWT
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        // Basic deshabilitado (opcional)
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
