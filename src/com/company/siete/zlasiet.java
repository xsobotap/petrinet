package com.company.siete;

import com.company.Hrany.HranaSiete;
import com.company.Petrinet;

public class zlasiet extends Petrinet {
    HranaSiete h1;

    public zlasiet() {
    }

    public void setup(){
        try {
            h1=new HranaSiete(2,null,null,1);
            this.addHrana(h1);
        }catch (Exception e){
            System.out.println("neico je zle");
        }



    }
}
