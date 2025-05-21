package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<Stock> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void tradeStock(Stock stock, double bid, int metric) {
        if (stocks.contains(stock)) {
            // Calculate the new stock price based on bid and metric
            double currentPrice = stock.getPrice();
            double newPrice = currentPrice + (bid - currentPrice) * (metric / 100.0);
            stock.setPrice(newPrice);
        } else {
            System.out.println("Stock not found in the market.");
        }
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public void showAllStocks() {
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }


    public static void demo() {


        System.out.println("");

        StockSubClass1 stock1 = new StockSubClass1("AAL", 11.15, "American Airlines Stock");

        StockSubClass2 stock2 = new StockSubClass2("TSLA", 320.50, "Tesla Inc. Stock");


        // Get the StockMarket instance

        StockMarket stockMarket = StockMarket.getInstance();


        // Add stocks to the market

        stockMarket.addStock(stock1);

        stockMarket.addStock(stock2);


        // Set bids for the stocks

        stock1.setBid(132.0);

        stock1.setBid(135.0);

        stock1.setBid(140.0);

        stock1.setBid(151.0);

        stock1.setBid(155.0);

        stock1.setBid(160.0);


        // Show all stocks in the market

        stockMarket.showAllStocks();


        // Get metrics for the stocks

        int metric1 = stock1.getMetric();

        int metric2 = stock2.getMetric();


        System.out.println("Metric for stock1: " + metric1);

        System.out.println("Metric for stock2: " + metric2);

    }
}
