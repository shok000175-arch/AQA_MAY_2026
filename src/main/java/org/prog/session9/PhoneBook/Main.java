package org.prog.session9.PhoneBook;

import java.util.ArrayList;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {

        HashMap<Phone, ArrayList<PhoneBookRecords>> phoneBooks = new HashMap<>();

        Phone samsung = new Phone("Samsung");
        Phone iphone = new Phone("iPhone");

        ArrayList<PhoneBookRecords> samsungContacts = new ArrayList<>();
        samsungContacts.add(new PhoneBookRecords("John", "111-111"));
        samsungContacts.add(new PhoneBookRecords("Kate", "222-222"));

        ArrayList<PhoneBookRecords> iphoneContacts = new ArrayList<>();
        iphoneContacts.add(new PhoneBookRecords("Mike", "333-333"));

        phoneBooks.put(samsung, samsungContacts);
        phoneBooks.put(iphone, iphoneContacts);

        System.out.println(phoneBooks);
    }
}
