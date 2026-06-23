import java.util.*;

public class StockMarketAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] stocks = {
                "TCS",
                "Infosys",
                "Reliance",
                "HDFC Bank",
                "ITC",
                "Wipro",
                "ICICI Bank"
        };

        int[] scores = new int[stocks.length];

        System.out.println("===================================");
        System.out.println("      STOCK MARKET ANALYZER");
        System.out.println("===================================");

        System.out.print("Enter Amount to Invest (Rs): ");
        double amount = sc.nextDouble();

        int marketScore = 60 + rand.nextInt(41);  //60+25=85

        String marketTrend;

        if (marketScore >= 85) { //85
            marketTrend = "Bullish"; 
        } else if (marketScore >= 70) {
            marketTrend = "Neutral";
        } else {
            marketTrend = "Bearish";
        }

        for (int i = 0; i < scores.length; i++) {
            scores[i] = 60 + rand.nextInt(41);    //TCS=82 , Infosys =72, Reliance=79, HDFC Bank=81, ITC=90, Wipro=75, ICICI Bank=77
        }

        int bestIndex = 0;

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[bestIndex]) {    //82>0 =T ,72>82=F ,79>82=F ,81>82=F.90>82=T ,75>90=F ,77>90=F
                bestIndex = i;                      //BI=82,BI=90,
            }
        }

        System.out.println("\n========== MARKET ANALYSIS ==========");
        System.out.println("Market Score : " + marketScore + "/100"); //85/100
        System.out.println("Market Trend : " + marketTrend); //Bullish

        if (marketScore >= 75) {
            System.out.println("Recommendation : INVEST");
        } else {
            System.out.println("Recommendation : WAIT");
        }

        System.out.println("\n========== STOCK SCORES ==========");

        for (int i = 0; i < stocks.length; i++) {
            System.out.println(stocks[i] + " -> " + scores[i]);
        }

        System.out.println("\n========== BEST STOCK ==========");
        System.out.println("Recommended Stock : " + stocks[bestIndex]);
        System.out.println("Stock Score       : " + scores[bestIndex]);

        double expectedReturn =
                amount + (amount * scores[bestIndex] / 100.0);

        System.out.printf("Investment Amount : Rs%.2f\n", amount);
        System.out.printf("Estimated Value   : Rs%.2f\n",
                expectedReturn);

        System.out.println("\n========== TOP 3 STOCKS ==========");

        int[] tempScores = scores.clone();

        for (int rank = 1; rank <= 3; rank++) {

            int top = 0;

            for (int i = 1; i < tempScores.length; i++) {
                if (tempScores[i] > tempScores[top]) {
                    top = i;
                }
            }

            System.out.println(rank + ". "
                    + stocks[top]
                    + " (Score: "
                    + tempScores[top] + ")");

            tempScores[top] = -1;
        }

        System.out.println("\n========== SCORE GRAPH ==========");

        for (int i = 0; i < stocks.length; i++) {

            System.out.printf("%-12s | ", stocks[i]);

            for (int j = 0; j < scores[i] / 2; j++) {
                System.out.print("*");
            }

            System.out.println(" " + scores[i]);
        }

        System.out.println("\n========== FINAL DECISION ==========");

        if (marketScore >= 85 && scores[bestIndex] >= 85) {
            System.out.println("Strong Buy Opportunity");
        } else if (marketScore >= 70) {
            System.out.println("Moderate Buy Opportunity");
        } else {
            System.out.println("Market Risk High - Wait & Watch");
        }

        System.out.println("\nThank You For Using Stock Market Analyzer");

        sc.close();
    }
}