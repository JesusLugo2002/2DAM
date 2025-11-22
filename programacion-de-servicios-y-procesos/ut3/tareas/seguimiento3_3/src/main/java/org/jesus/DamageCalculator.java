package org.jesus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Clase DamageCalculator.
 * Simula el ataque de una raid donde cada jugador lanza un ataque
 * y el servidor gestiona si dicho ataque fue critico o no, mostrando
 * al finalizar los resultados, haciendo uso de un FixedThreadPool y los metodos
 * .submit() junto a la gestion de futuros.
 * 
 * @author JesusLugo2002
 */
public class DamageCalculator {
    /**
     * Clase Attack.
     * Representa un ataque con el nombre del atacante, el danio base,
     * la probabilidad de critico y el danio critico.
     * 
     * @author JesusLugo2002
     */
    static class Attack {
        final String attacker;
        final int baseDamage;
        final double critChance;
        final double critDamage;
        final double precision;

        /**
         * Constructor con asignacion de valores.
         * 
         * @param attacker   - Nombre del atacante
         * @param baseDamage - Danio base.
         * @param critChance - Probabilidad de critico (0.25 = 25%)
         * @param critDamage - Danio critico (2.0 = x2)
         * @param precision - Probabilidad de asestar el golpe. (0.75 = 75%)
         */
        Attack(String attacker, int baseDamage, double critChance, double critDamage, double precision) {
            this.attacker = attacker;
            this.baseDamage = baseDamage;
            this.critChance = critChance;
            this.critDamage = critDamage;
            this.precision = precision;
        }
    }

    /**
     * Clase CalculateDamageTask.
     * Tarea que contiene el procedimiento principal de realizar un ataque,
     * con sus datos previamente asignados por medio del constructor.
     * 
     * @author JesusLugo2002
     */
    static class CalculateDamageTask implements Callable<Integer> {
        private final Attack attack;

        /**
         * Constructor con asignacion de ataque.
         * 
         * @param attack - Instancia de {@code Attack}
         */
        CalculateDamageTask(Attack attack) {
            this.attack = attack;
        }

        /**
         * Procedimiento principal de la tarea.
         * Cuando se inicia el ataque, se calcula la probabilidad de que este sea
         * critico, y en base a este resultado se determina un resultado o danio final.
         * Los resultados son mostrados en pantalla y luego retornado.
         * 
         * @return Danio final calculado tras determinar si es critico o no.
         */
        @Override
        public Integer call() throws Exception {
            String thread = "[" + Thread.currentThread().getName() + "]";
            System.out.println(thread + " Calculando daño para " + attack.attacker);
            boolean hitSuccessful = Math.random() < attack.precision;
            if (!hitSuccessful) {
                System.out.println(thread + " ¡Falló! No ha asestado el golpe.");
                return 0;
            }
            boolean isCritical = Math.random() < attack.critChance;
            double multiplier = isCritical ? attack.critDamage : 1.0;
            Thread.sleep(500 + (int) (Math.random() * 500));
            int finalDamage = (int) (attack.baseDamage * multiplier);
            System.out.println(thread + " " + attack.attacker +
                    (isCritical ? " ¡CRÍTICO!" : " golpe normal") +
                    " -> daño: " + finalDamage);
            return finalDamage;
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();

        // Simulacion de la raid - Se crean los ataques.
        Attack[] attacks = {
                new Attack("Mago del Fuego", 120, 0.30, 2.5, 0.5),
                new Attack("Guerrero", 150, 0.15, 2.0, 1.0),
                new Attack("Pícaro", 90, 0.50, 3.0, 1.0),
                new Attack("Arquera Élfica", 110, 0.35, 2.2, 0.9),
                new Attack("Invocador", 80, 0.40, 2.8, 0.9),
                new Attack("Paladín", 130, 0.10, 1.8, 0.5),
                new Attack("Bárbaro", 160, 0.20, 2.1, 0.7),
                new Attack("Nigromante", 100, 0.25, 2.3, 0.5),
        };

        // Enviamos todas las tareas al pool
        for (Attack attack : attacks) {
            Future<Integer> futuro = pool.submit(new CalculateDamageTask(attack));
            futures.add(futuro);
        }

        // Recogemos resultados
        int totalRaidDamage = 0;
        for (int i = 0; i < attacks.length; i++) {
            try {
                int damage = futures.get(i).get();
                totalRaidDamage += damage;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Lectura de resultado interrumpida");
            } catch (ExecutionException e) {
                System.out.println("Error calculando daño: " + e.getCause());
            }
        }
        int averageDamage = totalRaidDamage / attacks.length;

        System.out.println("Daño total de la raid: " + totalRaidDamage);
        System.out.println("Daño promedio de la raid: " + averageDamage);
        pool.shutdown();
    }
}
