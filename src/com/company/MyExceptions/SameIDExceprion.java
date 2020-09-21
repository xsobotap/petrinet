package com.company.MyExceptions;

import com.company.Hrany.HranaSiete;
import com.company.Prvky.PrvokSiete;

import java.security.spec.ECFieldF2m;

public class SameIDExceprion extends Exception {
    public SameIDExceprion(PrvokSiete prvok){
        super("Prvok "+ prvok.getId() +" s tymto ID uz existuje v tejto sieti");
    }

    public  SameIDExceprion(HranaSiete hrana){
        super("Hrana " + hrana.getId() +" s tymto ID uz existuje v tejto sieti");
    }
}
