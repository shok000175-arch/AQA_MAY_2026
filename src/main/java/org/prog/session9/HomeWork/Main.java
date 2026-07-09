package org.prog.session9.HomeWork;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {


        HashMap<Phone, ArrayList<PhoneBookRecord>> phoneBooks = new HashMap<>();

        Phone samsung = new Phone("Samsung");
        Phone iphone = new Phone("iPhone");

        ArrayList<PhoneBookRecord> samsungBook = new ArrayList<>();
        samsungBook.add(new PhoneBookRecord("John", "111-111"));
        samsungBook.add(new PhoneBookRecord("Kate", "222-222"));

        ArrayList<PhoneBookRecord> iphoneBook = new ArrayList<>();
        iphoneBook.add(new PhoneBookRecord("Mike", "333-333"));

        phoneBooks.put(samsung, samsungBook);
        phoneBooks.put(iphone, iphoneBook);


        System.out.println(phoneBooks);
    }
}
