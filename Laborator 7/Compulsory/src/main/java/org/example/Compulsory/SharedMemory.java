package org.example.Compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SharedMemory {
    private final List<Token> tokens;
    private final int nrTokens;

    public SharedMemory(int n) {
        this.nrTokens = n * n * n;
        this.tokens = new CopyOnWriteArrayList<>();//needs to be thread-safe
        for (int i = 0; i < nrTokens; ++i) {
            this.tokens.add(new Token(i));
        }
        Collections.shuffle(this.tokens);
    }

    public synchronized List<Token> extractTokens (int tokensToBeExtracted){
        List <Token> extracted = new ArrayList<>();
        for( int i=0 ; i < tokensToBeExtracted ; ++i){
            if(this.tokens.isEmpty()){
                break;
            }
            extracted.add(this.tokens.get((int) (Math.random() * this.nrTokens)));
        }
        return extracted;
    }

}
