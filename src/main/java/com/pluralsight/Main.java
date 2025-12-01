package com.pluralsight;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    private static String input = " ";

    private static MysqlDataSource dataSource = new MysqlDataSource();

    public static void main(String[] args) {

        dataSource.setURL(args[0]);
        dataSource.setUser(args[1]);
        dataSource.setPassword(args[2]);

        boolean running = true;
        while(running){
            System.out.print("What is your favorite actor's last name: ");
            input = scanner.nextLine().toUpperCase();
            DB.lastNameQuery(input, dataSource);
            running = false;
        }

        while(!running) {
            System.out.println("Search actor by name");
            System.out.print("First name: ");
            String firstName = scanner.nextLine().toUpperCase();
            System.out.print("Last name: ");
            String lastName = scanner.nextLine().toUpperCase();
            DB.movieSearchByNameQuery(firstName, lastName, dataSource);
        }
    }
}
