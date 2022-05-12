package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {

    private static final double COST_PER_KM = 10.0;
    private static final double COST_PER_MIN = 1.0;
    private static final double MIN_FARE = 5;
    static Map<String, Ride[]> map = new HashMap<>();

    public double calculateFare(double distance, int time) {
        double totalFare = (distance * COST_PER_KM) + (time * COST_PER_MIN);

        if (totalFare < MIN_FARE) {
            return MIN_FARE;
        }
        return totalFare;
    }
    public InvoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride:rides){
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public void addRides(String userID, Ride[] rides){
        map.put(userID,rides);
    }

    public InvoiceSummary getInvoiceService(String userID){
        Ride[] ride = map.get(userID);
        InvoiceSummary invoiceSummary = new InvoiceGenerator().calculateFare(ride);
        return invoiceSummary;
    }
}
