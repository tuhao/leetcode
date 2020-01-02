package dynamic;

import java.util.HashMap;
import java.util.Map;

//322. Coin Change
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        boolean[][] state = new boolean[amount][amount + 1];
        for (int money : coins) {
            if (money <= amount) state[0][money] = true;
        }
        for (int i = 1; i < amount; i++) {
            for (int j = 1; j <= amount; j++) {
                for (int money : coins) {
                    if (state[i - 1][j]) {
                        if (money + j <= amount) state[i][j + money] = true;
                        if (state[i][money]) return i + 1;
                    }
                }
            }
        }
        return -1;

    }

}
