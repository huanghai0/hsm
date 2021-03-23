package future;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TaskDemo {

    static enum Result {
        SUCCESS, FAIL, CANCELLED
    }

    static List<MyTask> tasks = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        tasks.add(new MyTask("t1", 5, Result.SUCCESS));
        tasks.add(new MyTask("t2", 3, Result.FAIL));
        tasks.add(new MyTask("t3", 1, Result.SUCCESS));

        for (MyTask task : tasks) {
            CompletableFuture cf = CompletableFuture.supplyAsync(() -> task.call())
                    .thenAccept((result) -> callback(result, task));
        }

        System.in.read();

    }

    private static void callback(Result result, MyTask task) {
        if (Result.FAIL == result) {

            for (MyTask _task : tasks) {
                if (_task != task) {
                    _task.cancel();
                }
            }
        }

    }

    static class MyTask {
        private String name;
        private int time;
        private Result ret;

        volatile boolean canceling = false;
        volatile boolean cancelled = false;

        public MyTask(String name, int time, Result ret) {
            this.name = name;
            this.time = time * 1000;
            this.ret = ret;
        }

        public Result call() {
            int interval = 100;
            int total = 0;

            try {
                for (; ; ) {
                    Thread.sleep(interval);
                    total += interval;
                    if (total >= time) {
                        break;
                    }
                    if (cancelled) {
                        return Result.CANCELLED;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ": call()执行完成!");
            return ret;
        }

        public void cancel() {
            if (!cancelled) {
                synchronized (this) {
                    if (cancelled) return;
                    canceling = true;
                    System.out.println(name + ": canceling");
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + ": cancel() 完成！");
                }
                cancelled = true;
            }
        }
    }
}
