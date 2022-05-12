package com.bridgelabz;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator;

    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    /*
        UC1 : Calculate total fare.
         */
    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        invoiceGenerator.calculateFare(distance, time);
        double totalFare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare, 0);
    }

    @Test
    public void givenLessDistanceAndTime_shouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    /**
     * UC 2 Multiple Rides.
     */
    @Test
    public void givenMultipleRides_shouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    /**
     * UC 3 - Enhanced Invoice
     */
    @Test
    public void givenMultipleRides_shouldReturninvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    /**
     * UC 4 - Invoice Service
     */
    @Test
    public void givenUserAndRides_ShouldReturnInvoiceSummary() {
        String user = "mangeshb9903@gmail.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceGenerator.addRides(user, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceService(user);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }


    /**
     * UC 5 - Premium Rides (Bonus)
     */
    @Test
    public void givenNormalAndPremiumRides_ShouldReturnInvoiceSummary() {
        String user1 = "Mangesh";
        Ride[] rides1 = {new Ride(RideCategory.PREMIUM, 2.0, 5), new Ride(RideCategory.NORMAL, 0.1, 1)};
        invoiceGenerator.addRides(user1, rides1);
        String user2 = "Archana";
        Ride[] rides2 = {new Ride(RideCategory.PREMIUM, 3.0, 5), new Ride(RideCategory.NORMAL, 0.1, 1)};
        invoiceGenerator.addRides(user2, rides2);
        InvoiceSummary summary = invoiceGenerator.getInvoiceService(user1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}