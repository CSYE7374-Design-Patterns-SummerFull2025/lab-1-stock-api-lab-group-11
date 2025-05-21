package edu.neu.csye7374;

public class StockSubClass1 extends Stock implements Tradable.Tradable0 {
    private double[] bids = new double[6];
    private int currentIndex = 0;

    public StockSubClass1(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setBid(double bid) {
        if (currentIndex < 6) {
            bids[currentIndex++] = bid;
            updatePrice();
        }
    }

    @Override
    public int getMetric() {
        // Implement a custom metric calculation based on the bids
        double sum = 0;
        for (double bid : bids) {
            sum += bid;
        }
        return (int) (sum / 10); // Adjust your metric calculation logic as needed
    }

    private void updatePrice() {
        // Implement logic to update the stock price based on bids
        double sum = 0;
        for (double bid : bids) {
            sum += bid;
        }
        double averageBid = sum / currentIndex;
        // Update the stock price based on your calculation by re-creating the Stock object
        Stock updatedStock = new Stock(getName(), averageBid, getDescription());
        // Copy the updated values back to this StockSubClass1 object
        setName(updatedStock.getName());
        setPrice(updatedStock.getPrice());
        setDescription(updatedStock.getDescription());
    }
}
