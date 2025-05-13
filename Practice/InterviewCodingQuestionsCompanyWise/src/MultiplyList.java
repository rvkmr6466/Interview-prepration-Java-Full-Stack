import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplyList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> multipliedNumbers = numbers.stream()
                .reduce(new ArrayList<>(), (list, number) -> {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(number * 2);
                    return (ArrayList<Integer>) newList;
                }, (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                });

        System.out.println(multipliedNumbers); // Output: [2, 4, 6, 8, 10]
    }
}
