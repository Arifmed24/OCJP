package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Aif Balaev
 * on 14/03/2018.
 */
public class WorkingWithExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            executorService.execute(() -> System.out.println("printing lambda command"));
            Future<?> future = executorService.submit(() -> System.out.println("printing lambda command"));
            future.isDone();
            future.isCancelled();
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> {
                for (int i = 0; i < 3; i++) System.out.println("loop " + i);
            });
            executorService.execute(() -> System.out.println("printing lambda 2"));
            System.out.println("end");
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }
}
