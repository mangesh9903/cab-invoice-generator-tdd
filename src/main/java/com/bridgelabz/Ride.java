package com.bridgelabz;

public class Ride {
    public RideCategory category;
    public int time;
    public double distance;

    public Ride(double distance,int time) {
        this.time = time;
        this.distance = distance;
    }

    public Ride(RideCategory category, double distance, int time) {
        this.category = category;
        this.time = time;
        this.distance = distance;
    }
}
