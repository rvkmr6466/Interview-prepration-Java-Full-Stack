import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class Employee {
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name;
    }
}

public class StreamExample {

    public static void main(String[] args) {

        /*
        Convert a List of Strings to Uppercase using Streams.**
        convertListOfStrToUpperCase();
         */

        /*
        Iterate the list using stream and parallel stream
        streamAndParallelStream();
         */

        /*
        Count the number of strings in a list that start with a specific letter.
        countNoOfStringInList();
         */

        /*
        Find the maximum and minimum values in a list of integers using Streams.**
        findMaxAndMinValues();
         */

        /*
        Find common elements from two lists
        findCommonElementsFromGivenTwoLists();
         */

        /*
        Remove duplicate elements from a list using Streams.
        removeDuplicateFromAList();
        */

        /*
        Sort a list of strings using Stream API.**
        sortListOfString();
         */

        /*
        Sum all numbers in a list using reduce.**
        sumOfNumbersInAListUsingReduce();
         */

        /*
        Filter even numbers from a list using Stream API.**
        filterEvenNumberFromList();
         */

        /*
        Group a list of employees by department.**
        groupEmployeeByDept()
         */

        /*
        Find the second highest salary in a list of employees.**
        secondHighestSalary();
        */

        /*
        findMaxAndMinValues();
         */

        /*
        Sort a map by values using Streams.
        sortMapByValuesAscending();
         */


        /*
        Reverse words in a String.
        reverseWordsInString();
         */

        /*
        Count Char In a String
        countCharInString();
         */

        /*
        countNumbersInArray();
         */

        countAFromAString();

        /*
        Check if all strings in a list are non-empty using Stream API.**

         */
//        4. **Partition a list of integers into even and odd using Collectors.**
//        5. **Get a list of unique characters from a list of strings.**
//        6. **Map a list of employees to a list of their names.**
//        7. **Join all strings in a list with a delimiter.**


//
//        ---
//
//### 🔴 Advanced Level
//
//        1. **Find the top 3 highest paid employees in each department.**
//        2. **Implement a custom collector to reverse a list using Streams.**
//        3. **Flatten a list of lists using flatMap.**
//        4. **Detect if there are any duplicate elements using groupingBy/counting.**
//        5. **Use parallel streams to process a large dataset efficiently.**
//        6. **Write a collector to calculate average age by gender in a person list.**
//        7. **Combine multiple predicates in a stream filter.**
//        8. **Convert a nested map to a flat list of custom objects using Streams.**
//
//        ---


        /*
        TODO: sort hashmap with values
        Map<String, Integer> map = new HashMap<>();
        map.put("Zebra", 3);
        map.put("Elephant", 1);
        map.put("Tiger", 2);
         */

    }

    public static void convertListOfStrToUpperCase() {
        List<String> list = List.of("Ravi", "Kumar", "is", "a", "Software", "Engineer");

        List<String> uppercaseList = list.stream().map(x->x.toUpperCase()).collect(toList());

        System.out.println(uppercaseList.toString());
    }

    public static void streamAndParallelStream() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Stream API");
        list.stream().map(x->x*2).forEach(System.out::println);

        System.out.println("Parallelstream API");
        list.parallelStream().map(x->x*3).forEach(System.out::println);
    }

    public static void countNoOfStringInList() {

    }

    public static void findMaxAndMinValues() {
        List<Integer> list = Arrays.asList(23, 45, 54, 66, 77, 12, 11, 23, 99, 199, 3);
        int max = list.stream().max(Integer::compareTo).get();
        int min = list.stream().min(Integer::compareTo).get();
        System.out.println(max);
        System.out.println(min);
    }

    public static void findCommonElementsFromGivenTwoLists(){
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 9);

        List<Integer> common = list1.stream().filter(list2::contains).collect(toList());

        System.out.println(common);
    }

    public static void removeDuplicateFromAList(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 3, 5);
        Set<Integer> set = list.stream().collect(Collectors.toSet());

        List<Integer> distinctList = list.stream().distinct().collect(toList());

        System.out.println(set.toString());
        System.out.println(distinctList.toString());
    }

    public static void sortListOfString(){
        List<String> list = List.of("Ravi", "Kumar", "is", "a", "Software", "Engineer");

        // asc
        List<String> sortedList = list.stream().sorted().collect(toList());
        // desc
        List<String> sortedList1 = list.stream().sorted((e1,e2)->e2.compareTo(e1)).collect(toList());
        // case insensitive
        List<String> sortedList2 = list.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(toList());

        System.out.println(sortedList.toString());
        System.out.println(sortedList1.toString());
        System.out.println(sortedList2.toString());
    }

    public static void sumOfNumbersInAListUsingReduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 3, 5);

        Optional<Integer> sum = list.stream().reduce(Integer::sum);
        int sum1 = list.stream().reduce(0, Integer::sum);

        System.out.println(sum);
        System.out.println(sum1);
    }

    public static void filterEvenNumberFromList(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 3, 5);

        List<Integer> evenNumberList = list.stream().filter(x->x%2==0).collect(Collectors.toList());

        System.out.println(evenNumberList);
    }

    public static void groupEmployeeByDept() {
        List<Employee> list = Arrays.asList(
                new Employee("Alice", "IT", 10000),
                new Employee("Bob", "HR", 10000),
                new Employee("Chandler", "HR", 10000),
                new Employee("Dunkirk", "Professor", 10000),
                new Employee("Elina", "Professor", 10000),
                new Employee("Fanny", "Professor", 10000),
                new Employee("Gaga", "Professor", 10000)
        );

        Map<String, List<Employee>> listByDept = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        listByDept.forEach((key, value)-> {
            System.out.println(key + " : " + value);
        });
    }

    public static void secondHighestSalary() {
        List<Employee> list = Arrays.asList(
                new Employee("Alice", "IT", 10000),
                new Employee("Bob", "HR", 50000),
                new Employee("Chandler", "HR", 20000),
                new Employee("Dunkirk", "Professor", 35000),
                new Employee("Elina", "Professor", 40000),
                new Employee("Fanny", "Professor", 70000),
                new Employee("Gaga", "Professor", 80000)
        );
        double secondHighest = list.stream().mapToDouble(Employee::getSalary).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0.0);

        System.out.print(secondHighest);
    }

    public static void sortMapByValuesAscAndDesc(){
        Map<String, Integer> map = new HashMap<>();
        map.put("alice", 1);
        map.put("bob", 13);
        map.put("charlie", 2);
        map.put("donkey", 11);
        map.put("ellie", 4);
        map.put("fanny", 5);
        map.put("gaga", 7);
        map.put("himani", 3);
        Map<String, Integer> sortedMap = new HashMap<>();

        Map<String, Integer> sortedMap1 = map.entrySet()
                .stream()
                //.sorted(Map.Entry.comparingByValue()) // ascending
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // Changed to reversed()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new // preserve order
                ));
        System.out.println(sortedMap1);
    }

    public static void reverseWordsInString(){
        String s = "the sky is blue     and clean ";

        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        System.out.println("Original: \"" + String.join(" ", list) + "\"");
    }

    public static void countEveryCharInString(){
        String str="this is a java interview";
        Map<Character, Integer> map = new HashMap<>();

        for (int i =0; i<str.length(); i++) {
            int count = map.getOrDefault(str.charAt(i), 0);
            map.put(str.charAt(i), count+1);
        }
        System.out.println(map);
    }

    public static void countEveryNumbersInArray(){
        int[] arr = {1,2,3,4,2,2,3};
        Map<Integer, Integer> h = new HashMap<>();

        for (Integer n: arr) {
            int count = h.getOrDefault(n, 0);
            h.put(n, count+1);

        }
        System.out.println(h);
    }

    public static void countAFromAString() {
        String s = "adgafagagAagagag";

        char[] charArray = s.toCharArray();
        int i = 0;
        long count = 0;
        /* Approach 1 */
         int len = charArray.length-1;
         while(i < len) {
           if (charArray[i]=='a') {
             count++;
           }
           i++;
         }
         System.out.println("count of a :" + count);

        /* Approach 2: */
        count = s.chars() // IntStream of character codepoints
                .map(Character::toLowerCase)
                .filter(x -> (x=='a')).count();

        System.out.println(count);
    }


}



