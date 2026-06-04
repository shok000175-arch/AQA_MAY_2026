package org.prog.session5;

public class Plane {
    public String id;
    public int maxSeats;
    public int passengers;

    public Plane(String id, int passengers) {
        this.id = id;
        this.passengers = passengers;
        this.maxSeats = 200;
    }

    public int getFreeSeatsPercent() { int freeSeats = maxSeats - passengers;
        return (freeSeats * 100) / maxSeats;
    }

    public String info() {
        return "Plane " + id + " has " +  passengers + " passengers, free seats % = " + getFreeSeatsPercent();
    }
}
