package ltiMindtree;

import java.util.List;

@FunctionalInterface
interface Test {
    int sum(int a, int b);
}

public class CustomFunctionalInterface{

    public static void main(String[] args) {
        List<Integer> someArrayList = List.of(1,2,3,4);
        Test test = (a, b) -> a+b;
        System.out.println(someArrayList.stream().reduce(0, test::sum));
    }
}
