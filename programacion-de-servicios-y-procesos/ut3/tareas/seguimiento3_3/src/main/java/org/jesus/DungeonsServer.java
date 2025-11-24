package org.jesus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jesus.utils.ThreadLogger;

/**
 * Clase DungeonsServer.
 * Servidor de mazmorras online que gestionar la entrada de jugadores en sus
 * mazmorras designadas
 * haciendo uso de un FixedThreadPool para procesar los hilos de forma ordenada.
 * 
 * @author JesusLugo2002
 */
public class DungeonsServer {
    /**
     * Clase DungeonRequest.
     * Representa la peticion de un jugador para entrar a una mazmorra.
     * 
     * @author JesusLugo2002
     */
    static class DungeonRequest implements Runnable {
        private final String player;
        private final String dungeon;

        public String getPlayer() {
            return player;
        }

        public String getDungeon() {
            return dungeon;
        }

        /**
         * Constructor con asignacion del jugador y la mazmorra.
         */
        public DungeonRequest(String playerName, String dungeon) {
            this.player = playerName;
            this.dungeon = dungeon;
        }

        /**
         * Procedimiento principal de la clase.
         * Al iniciar la peticion, se imprime en pantalla que se esta cargando la
         * mazmorra para el jugador,
         * incluyendo en la informacion el identificador del hilo. Se suspende el hilo
         * con un tiempo aleatorio
         * para simular la exploracion del jugador en la mazmorra y, una vez el tiempo
         * haya terminado,
         * se imprime en pantalla que se ha finalizado la exploracion.
         */
        @Override
        public void run() {
            ThreadLogger logger = new ThreadLogger(Thread.currentThread());
            logger.out("Loading dungeon '" + dungeon + "' for the player " + player);
            try {
                Thread.sleep(1000 + (int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                logger.out("Interrupted " + player + " request.");
                Thread.currentThread().interrupt();
                return;
            }
            logger.out("Dungeon '" + dungeon + "' completed by " + player);
        }
    }

    public static void main(String[] args) {
        ExecutorService gmBots = Executors.newFixedThreadPool(3);
        String[] players = {
                "Link", "Zelda", "Geralt", "Yennefer", "Gandalf",
                "Frodo", "Aragorn", "Leia", "Luke", "DarthVader"
        };
        String[] dungeons = {
                "Catacumbas de Hyrule", "Torre Oscura", "Moria",
                "Estrella de la Muerte", "Nido de Dragón"
        };
        for (int i = 0; i < players.length; i++) {
            String player = players[i];
            String dungeon = dungeons[i % dungeons.length];
            gmBots.execute(new DungeonRequest(player, dungeon));
        }
        gmBots.shutdown();
        System.out.println("Server: all requests sent to the GM bots.");
    }
}
