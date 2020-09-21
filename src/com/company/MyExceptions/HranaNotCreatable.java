package com.company.MyExceptions;

import com.company.Hrany.HranaSiete;
import com.company.Prvky.Prechod;

public class HranaNotCreatable extends Exception {

    public HranaNotCreatable(HranaSiete hrana) {
        super("Hrana "+ hrana.getId()+" sa neda vytvorit z dovodu rovnakeho typu zaciatockeho a koncoveho objektu" +"");
    }
}