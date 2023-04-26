package org.example.Compulsory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final SharedMemory sharedMemory;
    private final ExplorationMap map;
    private final List<Robot> robots;

    public Exploration(int n) {
        this.sharedMemory = new SharedMemory(n);
        this.map = new ExplorationMap(n);
        this.robots = new ArrayList<>();
    }

    public SharedMemory getSharedMemory(){
        return this.sharedMemory;
    }
    public ExplorationMap getMap(){
        return this.map;
    }
    public void addRobot(Robot robot){
        robot.explore = this;
        this.robots.add(robot);
    }
    public void start(){
        for( Robot robot : this.robots){
            new Thread(robot).start();
        }
    }

}
