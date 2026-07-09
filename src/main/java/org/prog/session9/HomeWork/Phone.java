package org.prog.session9.HomeWork;

public class Phone {
    public String model;

    public Phone(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Phone) {
            Phone phone = (Phone) o;
            return model.equals(phone.model);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return model.hashCode();
    }
}

