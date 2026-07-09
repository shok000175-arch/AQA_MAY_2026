package org.prog.session10.HomeWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookTest {

    @Test
    public void checkPhoneBook() {

        List<PhoneBookRecord> phoneBook = new ArrayList<>();

        phoneBook.add(new PhoneBookRecord("John", "111111"));
        phoneBook.add(new PhoneBookRecord("Kate", "222222"));

        Assert.assertFalse(phoneBook.isEmpty());

        for (PhoneBookRecord record : phoneBook) {

            Assert.assertNotNull(record.name);
            Assert.assertNotNull(record.number);

        }
    }
}