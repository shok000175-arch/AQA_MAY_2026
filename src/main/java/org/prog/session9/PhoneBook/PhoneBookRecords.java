package org.prog.session9.PhoneBook;

public class PhoneBookRecords {
    public String name;
    public String phoneNumber;
    public PhoneBookRecords(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String toString(){
        return name + ":" + phoneNumber;
    }
}
