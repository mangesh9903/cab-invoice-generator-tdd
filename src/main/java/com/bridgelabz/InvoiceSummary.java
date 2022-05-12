package com.bridgelabz;

import java.util.Objects;

public class InvoiceSummary {
    private int noOfRides;
    private double totalFare;
    private double avgerageFare;

    public InvoiceSummary(int noOfRides, double totalFare) {
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return noOfRides == that.noOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.avgerageFare, avgerageFare) == 0;
    }
}
