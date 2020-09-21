package com.company.MyExceptions;

import com.company.Prvky.Prechod;

public class PrechodNotRunnableException extends Exception {

    public PrechodNotRunnableException(Prechod prechod) {
        super("Prechod "+ prechod.getName()+" sa neda spustit");
    }
}
