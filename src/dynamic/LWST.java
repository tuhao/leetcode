package dynamic;

public class LWST {


    private int minDist = Integer.MAX_VALUE;

    public int getMinDist() {
        return minDist;
    }

    public void setMinDist(int minDist) {
        this.minDist = minDist;
    }

    //莱文斯坦距离回溯解法
    public void lwstBT(char[] a, char[] b, int n, int m, int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) edist += (n - i);
            if (j < m) edist += (m - j);
            if (edist < minDist) minDist = edist;
            return;
        }
        if (a[i] == b[j]) {
            lwstBT(a, b, m, n, i + 1, j + 1, edist);
        } else {
            lwstBT(a, b, m, n, i + 1, j, edist + 1);
            lwstBT(a, b, m, n, i, j + 1, edist + 1);
            lwstBT(a, b, m, n, i + 1, j + 1, edist + 1);
        }
    }

    //莱文斯坦距离二维状态表解法
    public int lwstTable(char[] a, char[] b, int n, int m) {
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) {
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j - 1] + 1;
            else minDist[0][j] = 1;
        }
        for (int i = 0; i < n; ++i) {
            if (a[i] == b[0]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i - 1][0] + 1;
            else minDist[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j])
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                else minDist[i][j] = min(minDist[i][j - 1] + 1, minDist[i - 1][j] + 1, minDist[i - 1][j - 1] + 1);
            }
        }
        return minDist[n - 1][m - 1];
    }

    //最长公共子串长度二维状态解法
    public int lcs(char[] a, int n, char[] b, int m) {
        int[][] maxlcs = new int[n][m];
        for (int j = 0; j < m; ++j) {
            if (a[0] == b[j]) maxlcs[0][j] = 1;
            else if (j != 0) maxlcs[0][j] = maxlcs[0][j - 1];
            else maxlcs[0][j] = 0;
        }
        for (int i = 0; i < n; ++i) {
            if (a[i] == b[0]) maxlcs[i][0] = 1;
            else if (i != 0) maxlcs[i][0] = maxlcs[i - 1][0];
            else maxlcs[i][0] = 0;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) maxlcs[i][j] = max(maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1] + 1);
                else maxlcs[i][j] = max(maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1]);
            }
        }
        return maxlcs[n - 1][m - 1];
    }

    private int max(int a, int b, int c) {
        int max = Integer.MIN_VALUE;
        if (a > max) max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    private int min(int a, int b, int c) {
        int min = Integer.MAX_VALUE;
        if (a < min) min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }

    public static void main(String[] args) {
        int n = 6;
        int m = 6;
        char[] a = "mitcmu".toCharArray();
        char[] b = "mtacnu".toCharArray();
        LWST lwst = new LWST();
//        lwst.lwstBT(a, b, n, m, 0, 0, 0);
//        System.out.println(lwst.getMinDist());
//        int minDist = lwst.lwstTable(a, b, n, m);
//        System.out.println(minDist);
        int maxDist = lwst.lcs(a, n, b, m);
        System.out.println(maxDist);

    }
}
