package edu.neu.csye7374;

public interface Tradable {
    void setBid(double bid);

    int getMetric();

    interface Tradable0 {
        default void setBid(double bid) {
            // Default implementation for setBid in Tradable0
        }

        default int getMetric() {
            // Default implementation for getMetric in Tradable0
            return 0;
        }
    }

    interface Tradable1 {

        default int getMetric() {
            // Default implementation for getMetric in Tradable1
            return 0;
        }
    }
}
