package com.company.Prvky;

import com.company.Hrany.HranaSiete;
import com.company.Hrany.ResetHrana;
import com.company.MyExceptions.PrechodNotRunnableException;

public class Prechod extends PrvokSiete{
    boolean isRunning=false;
    int x;
    int y;
    public Prechod() {

    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isRunnable() {
        boolean b;
        if (this.incoming.size() == 0) {
            this.isRunning=true;
            return true;
        } else
        {
            for (HranaSiete hrana : this.incoming) {
                if((hrana instanceof ResetHrana)&&(hrana.getFrom().getTokens()==0)){
                  return false;

                }

                if (hrana.getFrom().getTokens() < hrana.getWeight()) {
                    this.isRunning=false;
                    return false;

                }
            }
    }
        this.isRunning=true;
        return true;

    }


    public void run() throws PrechodNotRunnableException {
        if(!isRunnable()){
            throw new PrechodNotRunnableException(this);

        }
        for(HranaSiete hrana : incoming){
            if(hrana instanceof ResetHrana){
                Miesto from = (Miesto) hrana.getFrom();
                from.setTokens(0);
            }

        }
        for(HranaSiete hrana : incoming){

            Miesto from = (Miesto) hrana.getFrom();
            from.removeTokens(hrana.getWeight());
            }


        for(HranaSiete hrana : outgoing){
            Miesto to = (Miesto) hrana.getTo();
            to.addTokens(hrana.getWeight());

        }

    }
}
