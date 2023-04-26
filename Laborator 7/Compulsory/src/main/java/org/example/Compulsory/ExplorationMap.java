package org.example.Compulsory;

import java.util.Arrays;

public class ExplorationMap {
    private final Cell[][] matrix;
    private final int sizeMatrix;
    private int cellsVisited = 0;

    public ExplorationMap(int n){
        this.sizeMatrix = n;
        this.matrix = new Cell[n][n];

        for( int i=0; i<n;++i){
            for(int j=0; j<n;++j){
                this.matrix[i][j] = new Cell();
            }
        }
    }

    public int getSizeMatrix(){
        return this.sizeMatrix;
    }
    public boolean finishedVisited(){
            return this.cellsVisited == this.sizeMatrix*this.sizeMatrix;
    }

    public boolean visit (int row, int col, Robot robot){
        synchronized (this.matrix[row][col]){
            if(!this.matrix[row][col].isVisited()){
                this.matrix[row][col].setTokens(robot.getExplore().getSharedMemory().extractTokens(this.sizeMatrix));
                this.matrix[row][col].setVisited(true);

                this.cellsVisited ++;
                System.out.println(robot.getName() + " inserted successfully tokens in " + row + " - " + col);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Matrix : \n");
        for(int i=0; i<this.sizeMatrix ; ++i){
            for( int j=0 ; j< this.sizeMatrix ; ++j){
                res.append("Cell["+i+"]["+j+"] visited(" + this.matrix[i][j].isVisited() + ") : " );
                res.append(this.matrix[i][j].getTokens());
                res.append("\n");
            }
        }

        return res.toString();
    }
}
