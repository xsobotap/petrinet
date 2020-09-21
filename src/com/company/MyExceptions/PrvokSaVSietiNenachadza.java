package com.company.MyExceptions;

import com.company.Prvky.PrvokSiete;

public class PrvokSaVSietiNenachadza extends Exception {
    public PrvokSaVSietiNenachadza(long id){
        super("Prvok s ID"+ id +" sa v sieti nenachadza");

    }
}
