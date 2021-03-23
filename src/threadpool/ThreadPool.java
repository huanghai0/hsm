package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPool implements Callable<String> {
    private String name;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();
        ThreadPool threadPool = new ThreadPool("tom");
//        Future<String> future = service.submit(threadPool);

        List<Future<String>> list = new ArrayList<>();
        list.add(service.submit(threadPool));
        for (Future<String> future : list) {
            System.out.println(future.isDone());
            System.out.println(future.get());
            System.out.println(future.isDone());
        }
        service.shutdown();
    }

    public ThreadPool(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return name;
    }
}
