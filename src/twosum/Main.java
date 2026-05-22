package twosum;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

                You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.



        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]

        Only one valid answer exists.
        */


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        twoSum(new int[]{2,7,11,15},  9);
        twoSum(new int[]{2,7,11,4},  6 );
        twoSum(new int[]{2,3,4},  7);
    }

    public static void twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println(nums[i] + " " + complement);
            }
            map.put(nums[i], i);
        }
    }
}