package concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Aif Balaev
 * on 18/03/2018.
 */
public class WorkingWithForkJoin {
    static class WeighAnimalAction extends RecursiveAction {
        private int start;
        private int end;
        private Double[] weights;

        public WeighAnimalAction(Double[] weights, int start, int end) {
            this.start = start;
            this.end = end;
            this.weights = weights;
        }

        @Override
        protected void compute() {
            if (end - start <= 3) {
                for (int i = start; i < end; i++) {
                    weights[i] = (double) new Random().nextInt(100);
                    System.out.println(i + " Animal weighed: " + weights[i]);
                }
            } else {
                int middle = start + ((end - start) / 2);
                System.out.println("[start= " + start + ", middle= " + middle + ", end= " + end + "]");
                invokeAll(new WeighAnimalAction(weights, start, middle), new WeighAnimalAction(weights, middle, end));
            }
        }

        public static void main(String[] args) {
            Double[] weights = new Double[10];

            ForkJoinTask<?> task = new WeighAnimalAction(weights, 0, weights.length);
            ForkJoinPool pool = new ForkJoinPool();
            pool.invoke(task);

            System.out.println();
            System.out.print("Weights: ");
            Arrays.asList(weights).stream().forEach(d -> System.out.println(d.intValue()));
        }
    }

    static class WeighAnimalTask extends RecursiveTask<Double> {
        private int start;
        private int end;
        private Double[] weights;

        public WeighAnimalTask(Double[] weights, int start, int end) {
            this.start = start;
            this.end = end;
            this.weights = weights;
        }

        @Override
        protected Double compute() {
            if (end - start <= 3) {
                double sum = 0;
                for (int i = start; i < end; i++) {
                    weights[i] = (double) new Random().nextInt(100);
                    System.out.println(i + " Animal weighed: " + weights[i]);
                    sum += weights[i];
                }
                return sum;
            } else {
                int middle = start + ((end - start) / 2);
                System.out.println("[start= " + start + ", middle= " + middle + ", end= " + end + "]");
                RecursiveTask<Double> otherTask = new WeighAnimalTask(weights, start, middle);
                otherTask.fork();
                return new WeighAnimalTask(weights, middle, end).compute() + otherTask.join();
            }
        }

        public static void main(String[] args) {
            Double[] weights = new Double[10];

            ForkJoinTask<Double> task = new WeighAnimalTask(weights, 0, weights.length);
            ForkJoinPool pool = new ForkJoinPool();
            Double sum = pool.invoke(task);
            System.out.println("Sum: " + sum);
        }
    }
}
