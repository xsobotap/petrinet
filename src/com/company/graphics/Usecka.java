package com.company.graphics;

import com.company.Hrany.HranaSiete;
import com.company.Prvky.PrvokSiete;

import java.awt.*;

public class Usecka extends Elements {
    PrvokSiete from;
    PrvokSiete to;
    int vaha;
    HranaSiete hranaSiete;
    Usecka(int x, int y, PrvokSiete from, PrvokSiete to, int vaha){
        super(x,y);
        this.from=from;
        this.to=to;
        this.vaha=vaha;
    }

    public HranaSiete getHranaSiete() {
        return hranaSiete;
    }

    public void setHranaSiete(HranaSiete hranaSiete) {
        this.hranaSiete = hranaSiete;
    }

    public void draw(Graphics g){
        int x;
        int y;
        if(this.from.getX()>this.to.getX()){
            x=this.to.getX();
        }else{
            x=this.from.getX();
        }
        if(this.from.getY()>this.to.getY()){
            y=this.to.getY();
        }else{
            y=this.from.getY();
        }
        g.drawLine(from.getX()+10,from.getY()+10,to.getX()+10,to.getY()+10);

        if(this.vaha==0){
            g.drawString("Reset hrana",
                    x + Math.abs((this.from.getX() - this.to.getX()) / 2),
                    y + Math.abs((this.from.getY() - this.to.getY()) / 2));
        }else {
            g.drawString(String.valueOf(this.vaha),
                    x + Math.abs((this.from.getX() - this.to.getX()) / 2),
                    y + Math.abs((this.from.getY() - this.to.getY()) / 2));
        }


        if((x==this.to.getX())&&(y==this.to.getY())){
            int xpoly [] = {this.to.getX()+10,this.to.getX()+10+10,this.to.getX()+4+10};
            int ypoly [] = {this.to.getY()+10,this.to.getY()+4+10,this.to.getY()+10+10};
            g.drawPolygon(xpoly,ypoly,3);
        }

        if((x==this.from.getX())&&(y==this.to.getY())){
            int xpoly [] = {this.to.getX()+10,this.to.getX()-10+10,this.to.getX()-4+10};
            int ypoly [] = {this.to.getY()+10,this.to.getY()-4+10,this.to.getY()+10+10};
            g.drawPolygon(xpoly,ypoly,3);
        }

        if((x==this.to.getX())&&(y==this.from.getY())){
            int xpoly [] = {this.to.getX()+10,this.to.getX()+4+10,this.to.getX()+10+10};
            int ypoly [] = {this.to.getY()+10,this.to.getY()-10+10,this.to.getY()-4+10};
            g.drawPolygon(xpoly,ypoly,3);
        }

        if((x==this.from.getX())&&(y==this.from.getY())){
            int xpoly [] = {this.to.getX()+10,this.to.getX()-4+10,this.to.getX()-10+10};
            int ypoly [] = {this.to.getY()+10,this.to.getY()-10+10,this.to.getY()+4+10};
            g.drawPolygon(xpoly,ypoly,3);
        }

    }

    public int getVaha() {
        return vaha;
    }

    public void setVaha(int vaha) {
        this.vaha = vaha;
    }

    public PrvokSiete getFrom() {
        return from;
    }

    public void setFrom(PrvokSiete from) {
        this.from = from;
    }

    public PrvokSiete getTo() {
        return to;
    }

    public void setTo(PrvokSiete to) {
        this.to = to;
    }
}

