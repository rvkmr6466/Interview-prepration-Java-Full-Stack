package iris;

public class ThousandsOfThreads {

    static class MyRunnable implements Runnable {
        private final int id;

        public MyRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            // Task to be performed by the thread
//            System.out.println("Thread " + id + " started");
//            try {
//                Thread.sleep(1000); // Simulate some work
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("Thread " + id + " finished");
        }
    }

    public static void main(String[] args) {
        int numberOfThreads = 1000; // Or more

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(new MyRunnable(i));
            thread.start();
        }
    }
}