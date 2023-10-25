package hilos;

import java.util.concurrent.Semaphore;

class Cliente implements Runnable {
        private int id;
        private Semaphore semaforo;

        public Cliente(int id, Semaphore semaforo) {
            this.id = id;
            this.semaforo = semaforo;
        }

        public void run() {
            try {
                semaforo.acquire();
                System.out.println("El cliente " + id + " está siendo atendido.");
                Thread.sleep(9000);
                System.out.println("El cliente " + id + " ha sido atendido.");
            }
            catch (InterruptedException e) { e.printStackTrace(); }
            finally { semaforo.release(); }
        }
    }

