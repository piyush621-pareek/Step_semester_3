public class Stocks {
    public static int buyAndSell(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;;
        int sellDay = 0;
        int buyDay = 0;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++ ) {
        if (prices[i] < lowestPrice) {
            lowestPrice = prices[i];
            buyDay = i;
        }
        int profit = prices[i] - lowestPrice;

        if (profit > maxprofit) {
            maxprofit = profit;
            sellDay = i;
        }
    }
    System.out.println("BUY ON: " + (buyDay + 1) + "PRICE AT : " + prices[buyDay] + "SELL ON: " + (sellDay + 1) + "Price AT: " + prices[sellDay]);
    return maxprofit;
}
public static void main(String [] args) {
    int [] prices = {7, 1, 2, 3, 6, 5};
    int result = buyAndSell(prices);
    System.out.println(result);

}
}

