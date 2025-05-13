package Capgemini;

public class CapgeminiDemo {
    public class FinallyBlockTest {
        public static void main(String[] args) {
            try {
                System.out.println("Inside try block");
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Inside catch block");
            } finally {
                System.out.println("Inside finally block");
            }
            System.out.println("Outside try-catch-finally block");
        }
    }

    public class Code {
        public static void main(String[] args) {
            method(null);
        }
        public static void method(Object o) {
            System.out.println("Object method");
        }
        public static void method(String s) {
            System.out.println("String method");
        }
    }

    public class Demo{
        public static void main(String[] arr){

        }
        public static void main(String arr){

        }
    }

}
