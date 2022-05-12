package com.bridgelabz;

import org.junit.Test;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        invoiceGenerator.calculateFare(distance, time);
    }

}
