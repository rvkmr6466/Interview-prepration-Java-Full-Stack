package ltiMindtree.customFunctionalInterfaceExamples;

public class CustomFunctionalInterfaceSecondExample {
    public static void main(String[] args) {
        // Lambda expression implementation
        MyFunction<String, Integer> stringLength = s -> s.length();
        System.out.println(stringLength.apply("Hello")); // Output: 5

        // Method reference implementation
        MyFunction<String, String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("world")); // Output: WORLD
    }

}

@FunctionalInterface
interface MyFunction<T, R> {
    R apply(T t);
}

