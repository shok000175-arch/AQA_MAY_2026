package org.prog.session15.HomeWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {

    public static void savePhone(String model, String price) {

        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "password"
            );

            String sql = "INSERT INTO Phones(model, price) VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, model);
            statement.setString(2, price);

            statement.executeUpdate();

            System.out.println("Phone saved to database");

            connection.close();

        } catch (Exception e) {

            System.out.println("Database error");
            System.out.println(e.getMessage());
        }
    }
}
