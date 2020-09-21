package com.company.graphics;

import com.company.Prvky.Miesto;

import javax.naming.Name;
import java.awt.*;

public class Kruh extends Elements {
    private int polomer=20;
    int Tokens;
    String name;
    int id;
    Miesto miesto;

    public Kruh(int x, int y,int Tokens,String name,int id){
        super(x,y);
        this.Tokens=Tokens;
        this.name=name;
        this.id=id;
    }
    public void draw(Graphics g){
        g.drawOval(this.getX(),this.getY(),40,40);
        g.drawString(String.valueOf(this.Tokens),this.getX()+20,this.getY()+20);
        g.drawString(this.name,this.getX(),this.getY());

    }

    public int getPolomer() {
        return polomer;
    }

    public void setPolomer(int polomer) {
        this.polomer = polomer;
    }

    public int getTokens() {
        return Tokens;
    }

    public void setTokens(int tokens) {
        Tokens = tokens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Miesto getMiesto() {
        return miesto;
    }

    public void setMiesto(Miesto miesto) {
        this.miesto = miesto;
    }
}
