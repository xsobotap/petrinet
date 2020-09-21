package com.company.graphics;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Elements {
private int x,y,id;

public Elements(int x, int y){
    this.x=x;
    this.y=y;

}

public abstract void draw(Graphics graphics2D);

//public abstract boolean contains(int x,int y);

//public abstract void clickOn(MouseEvent e);

public int getX(){
    return x;
}

public int getY(){
    return y;
}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
