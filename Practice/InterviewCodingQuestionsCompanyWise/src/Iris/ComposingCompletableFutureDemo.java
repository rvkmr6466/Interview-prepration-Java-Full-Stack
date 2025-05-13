package Iris;
import java.util.concurrent.*;

public class ComposingCompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> helloFuture
                    = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> greetingFuture
                    = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<String> combinedFuture
                = helloFuture.thenCombine(
                    greetingFuture, (m1, m2) -> m1 + " " + m2);

        System.out.println(combinedFuture.get()); // Hello World
    }

    // Handling Exception in CompletableFuture
    /*
    public static void main(String[] args) throws Exception
    {
        CompletableFuture<Integer> resultFuture
                // java.lang.ArithmeticException: / by zero
                = CompletableFuture.supplyAsync(() -> 10 / 0)
                .exceptionally(ex -> 0);

        // 0 - returned by exceptionally block
        System.out.println(resultFuture.get());
    }
    */
}
