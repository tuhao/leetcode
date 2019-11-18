package string;

import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                List<Integer> list = new ArrayList();
                list.add(i);
                map.put(nums[i], list);
            } else {
                map.get(nums[i]).add(i);
            }
        }
        Arrays.sort(nums);
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nums.length; i++) {
            int numA = target - nums[i];
            int temp = nums[i];
            nums[i] = 0;
            int index = Arrays.binarySearch(nums, numA);
            nums[i] = temp;
            if (index >= 0) {
                for (int j : map.get(nums[i])) {
                    for (int k : map.get(nums[index])) {
                        if (j != k) {
                            index1 = j;
                            index2 = k;
                            break;
                        }
                    }
                }
                if (index1 != -1 && index2 != -1) {
                    if (index1 > index2) {
                        index1 = index1 ^ index2;
                        index2 = index1 ^ index2;
                        index1 = index1 ^ index2;
                    }
                    return new int[]{index1, index2};
                }
            }
        }
        return new int[]{index1, index2};
    }


    public static void main(String[] args) {
        int target = 6;
        int[] nums = new int[]{3, 2, 4, 6};
        int[] result = new TwoSum().twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }

//        int i=5,j=6;
//        i=i^j;
//        j=i^j;
//        i=i^j;
//        System.out.println(i+":"+j);
    }

}
