package dynamic;

//121. Best Time to Buy and Sell Stock
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices = new int[]{7, 6, 4, 3, 1};
        BestTimeToBuyAndSellStock instance = new BestTimeToBuyAndSellStock();
        int result = instance.maxProfit(prices);
        System.out.println(result);
    }

}
