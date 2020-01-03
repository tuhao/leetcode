package dynamic;

//322. Coin Change
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        boolean[][] state = new boolean[amount][amount + 1];
        for (int coin : coins) {
            if (amount == coin) return 1;
            if (amount >= coin) state[0][coin] = true;
        }
        for (int i = 1; i < amount; i++) {
            for (int j = 1; j <= amount; j++) {
                if (state[i - 1][j]) {
                    for (int coin : coins) {
                        if (coin + j <= amount) state[i][j + coin] = true;
                        if (state[i][amount]) return i + 1;
                    }
                }
            }
        }
        return -1;
    }

    public int coinChangeBt(int[] coins, int amount) {
        if (amount == 0) return 0;
        for (int coin : coins) {
            if (coin == amount) return 1;
        }
        int res = 0;
        for (int coin : coins) {
            int next = coinChange(coins, amount - coin);
            res = 1 + Math.min(res, next);
        }
        return res;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(new int[]{2}, 3);
        System.out.println(result);
        result = coinChange.coinChangeBt(new int[]{2}, 3);
        System.out.println(result);
    }

}
