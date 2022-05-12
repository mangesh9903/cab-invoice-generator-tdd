package com.bridgelabz;

public enum RideCategory implements InvoiceService{
    PREMIUM(15,2,20),NORMAL(10,1,5);
    public double pricePerKm;
    public int pricePerMinute;
    public double minumumFarePerRide;

    RideCategory(double pricePerKm, int pricePerMinute, double minumumFarePerRide) {
        this.pricePerKm = pricePerKm;
        this.pricePerMinute = pricePerMinute;
        this.minumumFarePerRide = minumumFarePerRide;
    }

    @Override
    public double calculateCategoryFare(double distance, int time) {
        double totalFare = (distance * pricePerKm) + (time * pricePerMinute);
        return Math.max(totalFare,minumumFarePerRide);
    }
}
