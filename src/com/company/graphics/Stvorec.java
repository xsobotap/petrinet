package com.company.graphics;

import com.company.Prvky.Prechod;

import java.awt.*;

public class Stvorec extends Elements {
    boolean isRunning;
    String name;
    int id;
    Prechod prechod;

    public Stvorec(int x, int y, boolean isRunning, String name, int id, Prechod prechod){
        super(x,y);
        this.isRunning=isRunning;
        this.name=name;
        this.id=id;
        this.prechod=prechod;
    }
    public void draw(Graphics g){
        if(this.isRunning){
        g.setColor(Color.GREEN);
        }else{
        g.setColor(Color.WHITE);
        }
        g.fillRect(this.getX(),this.getY(),40,40);
        g.setColor(Color.black);
        //g.fillRect(this.getX(),this.getY(),3,3);
      if(this.getName()!=null) {
          g.drawString(this.name, this.getX() - 10, this.getY() + 60);
      }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
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

    public Prechod getPrechod() {
        return prechod;
    }

    public void setPrechod(Prechod prechod) {
        this.prechod = prechod;
    }
}
