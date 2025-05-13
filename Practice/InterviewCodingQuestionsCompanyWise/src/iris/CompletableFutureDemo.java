package iris;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> greetingFuture = CompletableFuture.supplyAsync(()->{
            return "Hello from CompletablFuture";
        });
        System.out.println(greetingFuture.get()); // Hello from CompletablFuture
    }
}
