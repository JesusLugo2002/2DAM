package com.docencia.objetos.config;

import org.springframework.context.annotation.*;

// Opcional: activar consola web y servidor TCP de H2 dentro de la app.
@Configuration @Profile("h2")
public class H2ServerConfig {
  @Bean(initMethod = "start", destroyMethod = "stop")
  public org.h2.tools.Server h2TcpServer() throws java.sql.SQLException {
    return org.h2.tools.Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
  }
  @Bean(initMethod = "start", destroyMethod = "stop")
  public org.h2.tools.Server h2WebServer() throws java.sql.SQLException {
    return org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
  }
}
