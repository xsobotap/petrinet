package com.company.Prvky;

import com.company.Hrany.HranaSiete;

public class Miesto extends PrvokSiete{

    int x;
    int y;
    public Miesto() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addTokens(int weight){
        this.tokens+=weight;
        System.out.println("Do miesta "+this.getId()+" sme pridali "+weight+" tokeny,  momentalne ma tokenov: "+this.getTokens());

    }


    public void removeTokens(int weight){
        if(weight<=tokens) {
            this.tokens -= weight;
            System.out.println("Z miesra "+this.getId()+" sme odobrali "+weight+" tokeny,  momentalne ma tokenov: "+this.getTokens());
        }

    }



}
