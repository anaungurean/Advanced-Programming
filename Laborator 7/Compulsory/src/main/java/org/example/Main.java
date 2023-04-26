package org.example;

import org.example.Compulsory.Exploration;
import org.example.Compulsory.Robot;

public class Main {
    public static void main(String[] args) {

        var explore = new Exploration(5);
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));

        explore.start();

    }
}