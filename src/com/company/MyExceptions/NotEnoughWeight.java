package com.company.MyExceptions;

import com.company.Hrany.HranaSiete;

public class NotEnoughWeight extends Exception {
    public NotEnoughWeight(HranaSiete hrana){
        super("Hrana "+ hrana.getId()+" sa neda vytvorit z dovodu ze nema minimalnu vahu 1" +"");

    }

}
