package com.company;
import com.company.Hrany.HranaSiete;
import com.company.Hrany.ResetHrana;
import com.company.MyExceptions.*;
import com.company.Prvky.Miesto;
import com.company.Prvky.Prechod;
import com.company.Prvky.PrvokSiete;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private Petrinet petrinet1;
    public Miesto m1=new Miesto();
    public Miesto m2=new Miesto();
    public Miesto m3=new Miesto();
    public Miesto m4=new Miesto();
    public Prechod p1=new Prechod();
    public HranaSiete h1;
    public HranaSiete h2;
    public HranaSiete h3;
    public ResetHrana h4;


    public Test() {
    }
    // Toto je metoda pomocou ktorej spustame akykolvek prechod v poli

    public void runIt(Petrinet pn,long id){
       for(int i=0;i<10;i++){
        try {
            pn.getPrechodByID(id).run();
        }catch(PrechodNotRunnableException | PrvokSaVSietiNenachadza e){
            System.out.println("Nie je moxne spustit prechod");
        }

    }

    }

    // Meetodou zisujem ci dany prvok sa v sieti nachadza a ak je miesto kolko ma tokenov

    public void checkPrvok(Petrinet  petrinet, long id){
      PrvokSiete prvok;
       try {
           prvok = petrinet.getPrvokByID(2);
       }catch (PrvokSaVSietiNenachadza e){
           System.out.println("Nie je moxne spustit prechod");
            return;
       }

       System.out.println("Prvok siete s id "+id+" ma "+prvok.getTokens()+" tokeny" );


    }




}
