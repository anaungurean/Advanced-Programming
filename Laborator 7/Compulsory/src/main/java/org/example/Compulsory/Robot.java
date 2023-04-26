package org.example.Compulsory;

import static java.lang.Thread.sleep;

public class Robot implements Runnable{
    private String name;
    private boolean running = true;
    Exploration explore;
    public Robot(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public Exploration getExplore(){
        return this.explore;
    }

    @Override
    public void run(){
        while (running){
            int row = (int) (Math.random() * this.explore.getMap().getSizeMatrix());
            int col = (int) (Math.random() * this.explore.getMap().getSizeMatrix());

            this.explore.getMap().visit(row,col,this);

            if(this.explore.getMap().finishedVisited()){
                running = false;
            }

            try {
                sleep(100);
            }
            catch (InterruptedException e) {
                System.err.print(e);
            }


        }
    }

}
