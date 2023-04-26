package org.example.Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Token> tokens;
    private boolean visited = false;
    public Cell(){
        this.tokens = new ArrayList<>();
    }

    public void addToken(Token token){
        this.tokens.add(token);
    }

    public void setTokens( List<Token> tokens){
        this.tokens = tokens;
    }
    public List<Token> getTokens(){
        return this.tokens;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }
}
