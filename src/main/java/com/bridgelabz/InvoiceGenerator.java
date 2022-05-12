package com.bridgelabz;

public class InvoiceGenerator {

    private static final double COST_PER_KM = 10.0;
    private static final double COST_PER_MIN = 1.0;
    private static final double MIN_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = (distance * COST_PER_KM) + (time * COST_PER_MIN);

        if (totalFare < MIN_FARE) {
            return MIN_FARE;
        }
        return totalFare;
    }
    public double calculateFare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride:rides){
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    public InvoiceSummary getInvoiceSummary(Ride[] rides) {
        double totalFare = calculateFare(rides);
        return new InvoiceSummary(rides.length, totalFare);
    }
}
