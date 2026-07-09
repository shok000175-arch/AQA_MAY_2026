package org.prog.session9.HomeWork;

public class PhoneBookRecord {
    public String name;
    public String phoneNumber;

    public PhoneBookRecord(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return name + " : " + phoneNumber;
    }
}

