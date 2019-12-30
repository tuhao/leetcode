package dynamic;

//一维dp数组的题目
//322. Coin Change
//121. Best Time to Buy and Sell Stock
//53. Maximum Subarray
//300. Longest Increasing Subsequence
//152. Maximum Product Subarray

//二维dp数组的题目
//152. Maximum Product Subarray
//120. Triangle


import java.util.Arrays;

//我们有一个数字序列包含 n 个不同的数字，
// 如何求出这个序列中的最长递增子序列长度？
// 比如 2, 9, 3, 6, 5, 1, 7 这样一组数字序列，
// 它的最长递增子序列就是 2, 3, 5, 7，所以最长递增子序列的长度是 4。
public class LongestNumbers {

    private int max = Integer.MIN_VALUE;

    public int getMax() {
        return max;
    }

    //  回溯解法
    public int bt(int[] a, int prev, int i) {
        if (i == a.length) return 0;
        int taken = 0;
        if (a[i] > prev) {
            taken = 1 + bt(a, a[i], i + 1);
        }
        int noTaken = bt(a, prev, i + 1);
        return Math.max(taken, noTaken);
    }

    public int longest(int[] a) {
        if (a.length == 0) return 0;
        int[] dp = new int[a.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 9, 3, 6, 5, 1, 7};
        int longest;
        LongestNumbers longestNumbers = new LongestNumbers();
        longest = longestNumbers.longest(a);
        System.out.println(longest);

        longest = longestNumbers.bt(a, Integer.MIN_VALUE, 0);
        System.out.println(longest);
    }
}
