package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataManager {

    public ArrayList<Actor> getActors(String firstName, String lastName) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("yearup");

        ArrayList<Actor> actors = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select actor_id, first_name, last_name from actor where first_name = ? and last_name = ?"
                );
        ) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("actor_id");
                    String dbFirstName = resultSet.getString("first_name");
                    String dbLastName = resultSet.getString("last_name");
                    actors.add(new Actor(id, dbFirstName, dbLastName));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return actors;
    }

}
