package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Aif Balaev
 * on 18/03/2018.
 */
public class WorkingWithCyclicBarier {
    static class LionPenManagerWithoutCyclicBarier {
        private void removeAnimals() {
            System.out.println("Removing animals");
        }

        private void cleanPen() {
            System.out.println("Cleaning the pen");
        }

        private void addAnimals() {
            System.out.println("Adding animals");
        }

        public void performTask() {
            removeAnimals();
            cleanPen();
            addAnimals();
        }

        public static void main(String[] args) {
            ExecutorService service = null;
            try {
                service = Executors.newFixedThreadPool(4); //created pool of 4 threads
                LionPenManagerWithoutCyclicBarier manager = new LionPenManagerWithoutCyclicBarier();
                for (int i = 0; i < 4; i++)
                    service.submit(() -> manager.performTask());
            } finally {
                if (service != null) service.shutdown();
            }
        }
    }

    static class LionPenManagerWithCyclicBarier {
        private void removeAnimals() {
            System.out.println("Removing animals");
        }

        private void cleanPen() {
            System.out.println("Cleaning the pen");
        }

        private void addAnimals() {
            System.out.println("Adding animals");
        }

        public void performTask(CyclicBarrier cyclicBarrier1, CyclicBarrier cyclicBarrier2) {
            try {
                removeAnimals();
                cyclicBarrier1.await();
                cleanPen();
                cyclicBarrier2.await();
                addAnimals();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            ExecutorService service = null;
            try {
                service = Executors.newFixedThreadPool(4);

                LionPenManagerWithCyclicBarier manager = new LionPenManagerWithCyclicBarier();
                CyclicBarrier cyclicBarrier1 = new CyclicBarrier(4);
                CyclicBarrier cyclicBarrier2 = new CyclicBarrier(4, () -> System.out.println("->Pen cleaned!"));
                for (int i = 0; i < 4; i++) {
                    service.submit(() -> manager.performTask(cyclicBarrier1, cyclicBarrier2));
                }
            } finally {
                if (service != null) service.shutdown();
            }
        }
    }
}
