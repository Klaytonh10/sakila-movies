package com.pluralsight;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        ArrayList<Actor> actors = dataManager.getActors("Bob", "Fawcett");

        for(Actor a : actors) {
            System.out.println(a.getActorID() + " " + a.getFirstName() + " "+ a.getLastName());
        }
    }
}
