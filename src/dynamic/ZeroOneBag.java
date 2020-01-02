package dynamic;

// 我们有一个背包，背包总的承载重量是 Wkg。
// 现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
// 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
public class ZeroOneBag {
    // 结果放到maxW中
    private int maxW = Integer.MIN_VALUE;


    public int getMaxW() {
        return maxW;
    }

    //备忘录
    private boolean[][] mem = new boolean[5][10];

    //回溯解法
    public void f(int[] weight, int n, int w, int i, int cw) {
        if (i == n || cw == w) {
            if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return;
        mem[i][cw] = true;
        //不放入i
        f(weight, n, w, i + 1, w);
        if (cw + weight[i] <= w) {
            //放入i
            f(weight, n, w, i + 1, cw + weight[i]);
        }
    }

    //动态规划，二维状态表
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] state = new boolean[n][w + 1];
        state[0][0] = true;
        if (weight[0] <= w) {
            state[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= w; ++j) {
                if (state[i - 1][j]) state[i][j] = state[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) {
                if (state[i - 1][j]) state[i][j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) {
            if (state[n - 1][i]) return i;
        }
        return 0;
    }

    //动态规划，一维数组
    public int knapsack2(int[] weight, int n, int w) {
        boolean[] state = new boolean[w + 1];
        if (weight[0] <= w) {
            state[weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = w - weight[i]; j >= 0; --j) {
                if (state[j]) state[j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) {
            if (state[i]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        // 物品重量
        int[] weight = {2, 2, 4, 6, 3};
        // 物品个数
        int n = 5;
        // 背包承受的最大重量
        int w = 9;
        ZeroOneBag zeroOneBag = new ZeroOneBag();
        zeroOneBag.f(weight, n, w, 0, 0);
        System.out.println(zeroOneBag.getMaxW());
        int i = zeroOneBag.knapsack(weight, weight.length, 9);
        System.out.println(i);
        i = zeroOneBag.knapsack2(weight, weight.length, 9);
        System.out.println(i);
    }

}
