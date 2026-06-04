package org.prog.session4;

public class Car {
    //поле класса
    public String color;
    public int maxSpeed;
    public String owner;

    //метод класса
    public void goTo(String destination) {
        System.out.println(color + " car starts engine");
        System.out.println(color + " car is going somewhere...");
        System.out.println(color + " car stops");
        System.out.println(color + " car belonging to " + owner + " goes to " + destination);
        }
    }
