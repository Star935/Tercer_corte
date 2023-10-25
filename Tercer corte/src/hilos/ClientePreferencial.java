package hilos;

import java.util.concurrent.Semaphore;

class ClientePreferencial implements Runnable {
        private int id;
        private Semaphore semaforoP;

        public ClientePreferencial(int id, Semaphore semaforoP) {
            this.id = id;
            this.semaforoP = semaforoP;
        }

        public void run() {
            try {
                semaforoP.acquire();
                System.out.println("El cliente preferencial " + id + " está siendo atendido.");
                Thread.sleep(1000);
                System.out.println("El cliente preferencial " + id + " ha sido atendido.");
            }
            catch (InterruptedException e) { e.printStackTrace(); }
            finally { semaforoP.release(); }
        }
    }



