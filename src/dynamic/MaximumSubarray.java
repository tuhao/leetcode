package dynamic;

import java.util.Arrays;

//53 Maximum Subarray
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            res = Math.max(sum, res);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                res = Math.max(sum, res);
            }
        }
        return res;
    }

//    public int maxSubArrayDP(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp,0);
//
//    }


    public static void main(String[] args) {
//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = new int[]{-2, 1};
        MaximumSubarray instance = new MaximumSubarray();
        int result = instance.maxSubArray(nums);
        System.out.println(result);
//        result = instance.maxSubArrayDP(nums);
//        System.out.println(result);

    }
}
