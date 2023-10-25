package hilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Simulacion {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Semaphore semaforo = new Semaphore(1);

        Semaphore semaforoP = new Semaphore(2);

        for (int i = 1; i <= 5; i++) {
            Cliente cliente = new Cliente(i, semaforo);
            executor.execute(cliente);
        }

        for (int b = 1; b <= 5; b++){
            ClientePreferencial clienteP = new ClientePreferencial(b,semaforoP);
            executor.execute(clienteP);
        }

        executor.shutdown();
    }
}
