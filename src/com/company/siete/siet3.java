package com.company.siete;

import com.company.Hrany.HranaSiete;
import com.company.Petrinet;
import com.company.Prvky.Miesto;
import com.company.Prvky.Prechod;

public class siet3 extends Petrinet {
    Miesto m1;
    Prechod p1;
    HranaSiete h1;

    public siet3() {

    }
    public void setup(){

        m1 = new Miesto();
        m1.setId(1);
        m1.setName("p3");
        m1.setTokens(0);

        try {
            this.addMiesto(m1);
        }catch (Exception e){
            System.out.println("nemozno vytvorit");
        }

        p1 = new Prechod();
        p1.setId(2);
        p1.setName("t4");


        try {
            this.addPrechod(p1);
        }catch (Exception e){
            System.out.println("nemozno vytvorit");
        }
        try {
            h1=new HranaSiete(3,m1,p1,1);
            this.addHrana(h1);
        }catch (Exception e){
            System.out.println("Hranu nemozno vytvorit");

        }
        h1.connectParts(m1,p1);
    }
}
