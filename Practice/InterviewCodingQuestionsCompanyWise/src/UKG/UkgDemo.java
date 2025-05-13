package UKG;

import java.util.Arrays;
import java.util.List;

public class UkgDemo {
//    @Autowired


    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1,2,3,4),
                Arrays.asList(5,6,7,8));

        Integer sum = list.stream().flatMap(List::stream).filter(n->n%2==0).reduce(0, Integer::sum);
        System.out.println(sum);
    }


}