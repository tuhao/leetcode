package dynamic;

// 假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。
// 如果我们要支付 w 元，求最少需要多少个硬币。
// 比如，我们有 3 种不同的硬币，1 元、3 元、5 元，我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）。

import java.util.HashMap;
import java.util.Map;

public class MinCoins {

    //邻接矩阵解法
    public static int minCoins(int money) {
        if (money == 1 || money == 3 || money == 5) return 1;
        boolean[][] state = new boolean[money][money + 1];
        if (money >= 1) state[0][1] = true;
        if (money >= 3) state[0][3] = true;
        if (money >= 5) state[0][5] = true;
        for (int i = 1; i < money; i++) {
            for (int j = 1; j <= money; j++) {
                if (state[i - 1][j]) {
                    if (j + 1 <= money) state[i][j + 1] = true;
                    if (j + 3 <= money) state[i][j + 3] = true;
                    if (j + 5 <= money) state[i][j + 5] = true;
                    if (state[i][money]) return i + 1;
                }
            }
        }
        return money;
    }

    //回溯
    static Integer coin = 0;
    static Map<Integer, Integer> map = new HashMap<>();

    public static int minCoin(int money) {
        if (money == 1) return 1;
        if (money == 2) return 2;
        if (money == 3) return 1;
        if (money == 4) return 2;
        if (money == 5) return 1;
        if (map.get(money) != null) {
            coin = map.get(money);
            return coin;
        }
        coin = 1 + min(minCoin(money - 1), minCoin(money - 3), minCoin(money - 5));
        map.put(money, coin);
        return coin;
    }

    static int min(int a, int b, int c) {
        if (a < b && a < c) return a;
        if (b < a && b < c) return b;
        return c;
    }

    public static void main(String[] args) {
        System.out.println(minCoins(999));
        System.out.println(minCoin(999));
    }
}
