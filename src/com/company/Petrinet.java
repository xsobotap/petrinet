package com.company;

import com.company.Hrany.HranaSiete;
import com.company.MyExceptions.PrvokSaVSietiNenachadza;
import com.company.MyExceptions.SameIDExceprion;
import com.company.Prvky.Miesto;
import com.company.Prvky.Prechod;
import com.company.Prvky.PrvokSiete;

import java.util.ArrayList;
import java.util.List;

public class Petrinet {

    List<Miesto>miesta;
    List<Prechod>prechody;
    List<HranaSiete>hrany;

    public Petrinet() {
        this.miesta = new ArrayList<>();
        this.prechody = new ArrayList<>();
        this.hrany = new ArrayList<>();
    }

    public void addMiesto(Miesto miesto)throws SameIDExceprion {
        for(Miesto m : miesta){
            if(m.getId()==miesto.getId()){
                throw new SameIDExceprion(miesto);
            }

        }
        miesta.add(miesto);

        System.out.println("Vytvoril som miesto s id "+miesto.getId()+" a poctom tokenov "+miesto.getTokens());
    }

    public void addPrechod(Prechod prechod) throws SameIDExceprion{
        for(Prechod p : prechody){
            if(p.getId()==prechod.getId()){
                throw new SameIDExceprion(prechod);
            }
        }
        prechody.add(prechod);

        System.out.println("Vytvoril som prechod s id "+prechod.getId());

    }

    public void addHrana(HranaSiete hrana)throws SameIDExceprion{
        for(HranaSiete h : hrany){
            if(h.getId()==hrana.getId()){
                throw new SameIDExceprion(hrana);
            }
        }
        hrany.add(hrana);

        System.out.println("Vtvoril som hranu meno vaha "+hrana.getWeight()+" from "+hrana.getFrom()+" to "+hrana.getTo() );

    }

    public List<Miesto> getMiesta() {
        return miesta;
    }

    public List<Prechod> getPrechody() {
        return prechody;
    }

    public List<HranaSiete> getHrany() {
        return hrany;
    }

    //ziskanie prvku na zaklade ID

    public PrvokSiete getPrvokByID(long id) throws PrvokSaVSietiNenachadza {

        for(PrvokSiete prvok : miesta){

            if(prvok.getId()==id){
            return prvok;
            }
        }
        for(PrvokSiete prvok : prechody){
            if(prvok.getId()==id){
                return prvok;
            }

        }

        throw new PrvokSaVSietiNenachadza(id);
    }


    // Ziskanie konkretne prechodu podla ID potrebneho v metode RunIt v triede Test

    public Prechod getPrechodByID(long id) throws PrvokSaVSietiNenachadza {

        for(Prechod prechod : prechody){

            if(prechod.getId()==id){
                return prechod;
            }
        }

        throw new PrvokSaVSietiNenachadza(id);
    }

    //ziskanie hrany na zaklade ID

    public HranaSiete getHranaByID(long id) throws PrvokSaVSietiNenachadza{
        for(HranaSiete hrana : hrany){
            if(hrana.getId()==id){
                return hrana;
            }

        }



        throw new PrvokSaVSietiNenachadza(id);
    }


}
