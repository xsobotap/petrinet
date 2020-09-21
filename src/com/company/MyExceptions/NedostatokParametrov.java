package com.company.MyExceptions;

import com.company.Hrany.HranaSiete;

public class NedostatokParametrov extends Exception {
    public NedostatokParametrov(HranaSiete hranaSiete) {
        super("Hrana siete "+hranaSiete.getId()+" nema dostatok aprametrov ");
    }
}
