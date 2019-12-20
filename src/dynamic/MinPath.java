package dynamic;

// 假设我们有一个 n 乘以 n 的矩阵 w[n][n]。矩阵存储的都是正整数。
// 棋子起始位置在左上角,终止位置在右下角。我们将棋子从左上角移动到右下角。
// 每次只能向右或者向下移动一位。从左上角到右下角,会有很多不同的路径可以走。
// 我们把每条路径经过的数字加起来看作路径的长度。
// 那从左上角移动到右下角的最短路径长度是多少呢？

public class MinPath {

    private int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};

    private int minDist = Integer.MIN_VALUE;

    //回溯解法
    //调用minDistBT(0,0,0,matrix,n)
    public void minDistBT(int i, int j, int dist, int[][] w, int n) {
        if (i == n && j == n) {
            if (dist < minDist) minDist = dist;
            return;
        }
        if (i < n) {
            minDistBT(i + 1, j, dist + w[i][j], w, n);
        }
        if (j < n) {
            minDistBT(i, j + 1, dist + w[i][j], w, n);
        }
    }

    //状态转移表解法
    public int minDistDP(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        for (int j = 0; j < n; ++j) {
            sum += matrix[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += matrix[i][0];
            states[i][0] = sum;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                states[i][j] = matrix[i][j] + Math.min(states[i][j - 1], states[i - 1][j]);
            }
        }
        return states[n - 1][n - 1];
    }

    //状态转移方程 min_dist(i,j)=w[i][j] + min(min_dist(i,j-1),min_dist(i-1,j))
    //备忘录
    private int[][] mem = new int[4][4];

    //调用minDist(n-1,n-1)
    public int minDist(int i, int j) {
        if (i == 0 && j == 0) return matrix[0][0];
        if (mem[i][j] > 0) return mem[i][j];
        int minLeft = Integer.MIN_VALUE;
        if (j - 1 >= 0) {
            minLeft = minDist(i, j - 1);
        }
        int minUp = Integer.MIN_VALUE;
        if (i - 1 >= 0) {
            minUp = minDist(i - 1, j);
        }
        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }

}
