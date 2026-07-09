package org.prog.session7.Iphone;

public class Apple implements IPhone {

    public String model;
    public String color;

    public Apple(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public void call(String contact) {
        System.out.println("Calling " + contact);
    }

    @Override
    public void unlock() {
        System.out.println("Unlocked with Face ID");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apple)) return false;

        Apple apple = (Apple) o;

        return model.equals(apple.model) &&
                color.equals(apple.color);
    }

    @Override
    public int hashCode() {
        return model.hashCode() + color.hashCode();
    }
}
