package org.prog.session3;

//TODO: print only valid emails
//TODO: valid email has:
//TODO: - at least 3 symbols before @
//TODO: - at least 7 symbols in domain (after @) (cannot start or end with dot)
//TODO: - 1 dot in domain
//TODO: - only one @

public class HomeWork {

    public static void main(String[] args) {
        String[] emails = {
                "asd.asd@asd.asd", //+
                "aa@asd.asd",
                "...@asd.asd", //+
                "asd.asd@asdasd.",
                "asd.asd@.asdasd",
                "asd@@.asdasd",
                "asd@@asd.asd",
                "some_email_that_is_very_long@long_domain_name.com"//+
        };
        for ( String email : emails) {
            if (email.indexOf('@') != email.lastIndexOf('@')) {
                continue;
            }
            if (!email.contains("@")) {
                continue;
            }
            String[] parts = email.split("@");

            if (parts.length != 2) {
                continue;
            }

            String name = parts[0];
            String domain = parts[1];

            if (name.length() < 3) {
                continue;
            }

            if (domain.length() < 7) {
                continue;
            }

            if (domain.startsWith(".") || domain.endsWith(".")) {
                continue;
            }

            int firstDot = domain.indexOf('.');
            int lastDot = domain.lastIndexOf('.');

            if (firstDot == -1 || firstDot != lastDot) {
                continue;
            }

            System.out.println(email);
        }
    }
}