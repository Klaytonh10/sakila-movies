package com.pluralsight;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB {

    private static ArrayList<Actor> actors;

    public static ArrayList<Actor> lastNameQuery(String input, MysqlDataSource dataSource) {

        actors = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM actor WHERE last_name LIKE '%" + input + "%';");
            ) {
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    String firstName = resultSet.getString("first_name").toLowerCase();
                    String lastName = resultSet.getString("last_name").toLowerCase();

                    Actor actor = new Actor(firstName, lastName);
                    actors.add(actor);
                }
                if(actors.size() > 0) {
                    for(Actor actor : actors) {
                        System.out.println(actor.getFirstName() + " " + actor.getLastName());
                    }
                } else {
                    System.out.println("\nNo actors with that name\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    public static ArrayList<Actor> movieSearchByNameQuery(String first, String last, MysqlDataSource dataSource) {

        actors = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM actor " +
                                "WHERE last_name LIKE '%" + first + " " + last + "%';"
                );
        ) {
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    String firstName = resultSet.getString("first_name").toLowerCase();
                    String lastName = resultSet.getString("last_name").toLowerCase();

                    Actor actor = new Actor(firstName, lastName);
                    actors.add(actor);
                }
                if(actors.size() > 0) {
                    for(Actor actor : actors) {
                        System.out.println(actor.getFirstName() + " " + actor.getLastName() + ":");

                    }
                } else {
                    System.out.println("\nNo actors with that name\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

}
