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
        Assert.assertEquals(25,totalFare,0);
    }
    @Test
    public void givenLessDistanceAndTime_shouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    /**
     *  UC 2 Multiple Rides.
     */
    @Test
    public void givenMultipleRides_shouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double fare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30, fare, 0.0);
    }

}
