package org.prog.session7.Iphone;

public class Android implements IPhone {

    public String model;
    public String color;

    public Android(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public void call(String contact) {
        System.out.println("Calling " + contact);
    }

    @Override
    public void unlock() {
        System.out.println("Unlocked with fingerprint");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Android)) return false;

        Android android = (Android) o;

        return model.equals(android.model) &&
                color.equals(android.color);
    }

    @Override
    public int hashCode() {
        return model.hashCode() + color.hashCode();
    }
}
