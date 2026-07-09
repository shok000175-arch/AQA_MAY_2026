package org.prog.session14;

import io.restassured.RestAssured;
import lombok.SneakyThrows;
import org.prog.session13.dto.PersonDto;
import org.prog.session13.dto.ResultsDto;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;

public class DBTests {

    private Connection connection;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db",
                "root", "password");
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        connection.close();
    }

    @SneakyThrows
    @Test
    public void dbTestSelect() {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Persons");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FirstName") + " " + resultSet.getString("LastName"));
        }
    }

    @SneakyThrows
    @Test
    public void dbTestInsert() {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                "VALUES ('Jane', 'Doe', 'female', 'Mrs', 'US')");
    }

    @SneakyThrows
    @Test
    public void dbTestStore() {
        ResultsDto resultsDto = RestAssured.get("https://randomuser.me/api?noinfo&inc=gender,name,nat&results=30")
                .as(ResultsDto.class);
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                        "VALUES (? , ? , ? , ? , ?)");

        for (PersonDto personDto : resultsDto.getResults()) {
            try {
                preparedStatement.setString(1, personDto.getName().getFirst());
                preparedStatement.setString(2, personDto.getName().getLast());
                preparedStatement.setString(3, personDto.getGender());
                preparedStatement.setString(4, personDto.getName().getTitle());
                preparedStatement.setString(5, personDto.getNat());
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failes to insert persons " + personDto);
            }
        }
    }
}
