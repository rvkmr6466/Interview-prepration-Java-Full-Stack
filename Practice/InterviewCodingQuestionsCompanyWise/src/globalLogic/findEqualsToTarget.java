package globalLogic;

import java.util.*;

public class findEqualsToTarget {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 8, 6, 3, 5, 7, 4, 8, 0);
        int target = 9;
        // [5,4] & [6,3] & [7,2]

//        List<List<Integer>> result1 = approach1(list, target);

        List<List<Integer>> result = findPairsWithSum(list, target);
        System.out.println(result);
    }

    public static List<List<Integer>> approach1(List<Integer> list, int target) {
        //        All possible pairs whose sum is 9
        List<List<Integer>> list1 = new ArrayList<>();

        int i=0, j=1;
        while(j < list.size()) {
            int sum=list.get(i)+list.get(j);
            System.out.println(list.get(i) + "::" +list.get(j));

            if(sum!=target){
                j++;
            } else {
                List<Integer> list2 = new ArrayList();
                list2.add(list.get(i));
                list2.add(list.get(j));
                list1.add(list2);
            }
            i++;
            j=i+1;
        }
        System.out.println(list1.toString());
        return list1;
    }

    //2, 8, 6, 3, 5, 7, 4, 8, 0
    public static List<List<Integer>> findPairsWithSum(List<Integer> list, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<String> usedPairs = new HashSet<>(); // To avoid duplicates
        List<List<Integer>> pairs = new ArrayList<>();
        for (Integer num : list) {
            int complement = target - num;
            if (seen.contains(complement)) {
                // To avoid duplicate pairs like (3,6) and (6,3), create a sorted key
                String pairKey = num < complement ? num + ":" + complement : complement + ":" + num;
                if (!usedPairs.contains(pairKey)) {
                    pairs.add(Arrays.asList(complement, num));
                    usedPairs.add(pairKey);
                }
            }
            seen.add(num);
        }
        return pairs;
    }
}
