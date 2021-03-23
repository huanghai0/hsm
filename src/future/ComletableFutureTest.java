package future;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComletableFutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        My my1 = new My("a", 3);
        My my2 = new My("b", 1);

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> my1.call())
                .thenApply((a) -> callback(a));

        Integer src = completableFuture.get();
        System.out.println(src);

        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(() -> my2.call())
                .thenAccept((a) -> callback(a));

        System.in.read();

    }

    private static Integer callback(int a) {
        System.out.println(a);
        return 100 + a;
    }

    static class My {
        private String name;
        private int num;


        public My(String name, int num) {
            this.name = name;
            this.num = num;
        }

        private Integer call() {
            try {
                Thread.sleep(num * 1000);
                System.out.println(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return num;
        }

    }

}
