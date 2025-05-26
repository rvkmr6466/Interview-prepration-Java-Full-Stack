package quessCorp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuessCorp {

/*
    Given an array of integers nums and an integer target, return three indices such that they add up to target.
    Input: nums = [1,2,3,4,5,6,7,8,9], target = 12
    nums[0] = 1
    nums[1] = 2
    nums[8] = 9
    Explanation: Because nums[0] + nums[1] + nums[8] == 12, so return [0,1,8]
*/
    public static void main(String[] args){
        int[] nums = {4,6,3,1,2,5,6,7,8,9};
        int target = 12;
        System.out.println("result:: " + approach1(nums, target));
    }

    private static List<Integer> approach2(int[] nums, int target) {
        int sum=0;

        List<Integer> result = new ArrayList<>();
        for(int k = 0; k < nums.length; k++) {
            sum+=nums[k];
            result.add(nums[k]);

            while (sum>target && !result.isEmpty()) {
                sum-=result.remove(result.size()-1);
                result.add(nums[k]);
            }
            System.out.println(result.toString());
            if (sum == target) {
                return new ArrayList<>(result);
            }
        }
        return new ArrayList<>();
    }

    private static List<Integer> approach3(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();  // Use a List instead of Stack
        int sum = 0;

        for (int k = 0; k < nums.length; k++) {
            sum += nums[k];
            result.add(nums[k]);  // Add the current number to the result

            // If the sum exceeds the target, remove the last added number until we are less than or equal to the target
            while (sum > target && !result.isEmpty()) {
                sum -= result.remove(result.size() - 1);
            }

            // Check if sum equals target
            if (sum == target) {
                return new ArrayList<>(result);  // Return a copy of the current result
            }
        }

        return new ArrayList<>();  // Return an empty list if no combination is found
    }

    private static List<Integer> approach1(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int currentTarget = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int complement = currentTarget - nums[j];
                if (map.containsKey(complement)) {
                    // Found the triplet indices
                    result.add(i);
                    result.add(map.get(complement));
                    result.add(j);
                    return result;
                }
                map.put(nums[j], j);
                System.out.println("map:: " + map);
            }
        }
        return result;  // Return empty list if no combination found
    }
}
