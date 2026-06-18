package org.prog.session9.PhoneBook;

public class Phone {
    public String model;
    public Phone (String model){
        this.model = model;
    }
    public boolean equals(Object o) {
        if (o instanceof Phone){
            Phone other = (Phone) o;
            return model.equals(other.model);
        }
        return false;
    }
    public int hashCod(){
        return model.hashCode();
    }
}
