package edu.neu.csye7374;

public class StockSubClass2 extends Stock implements Tradable.Tradable1 {
    private double[] bids = new double[6];
    private int currentIndex = 0;

    public StockSubClass2(String name, double price, String description) {
        super(name, price, description);
    }


    @Override
    public int getMetric() {
        // Implement a custom metric calculation based on the bids
        double maxBid = 50.0;
        for (double bid : bids) {
            if (bid > maxBid) {
                maxBid = bid;
            }
        }
        // Implement your custom metric calculation logic
        return (int) (maxBid / 10); // Adjust the metric calculation as needed
    }
}
