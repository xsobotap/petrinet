package com.company.Hrany;

import com.company.MyExceptions.HranaNotCreatable;
import com.company.MyExceptions.NedostatokParametrov;
import com.company.MyExceptions.NotEnoughWeight;
import com.company.Prvky.Miesto;
import com.company.Prvky.Prechod;
import com.company.Prvky.PrvokSiete;
import com.company.graphics.Elements;

public class HranaSiete {
    protected PrvokSiete from;
    protected PrvokSiete to;
    protected int weight;
    protected long id;
    Elements element;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Elements getElement() {
        return element;
    }

    public void setElement(Elements element) {
        this.element = element;
    }

    public HranaSiete(long id, PrvokSiete from, PrvokSiete to, int weight) throws HranaNotCreatable,NotEnoughWeight, NedostatokParametrov {
        if((from==null)||(to==null)){
            throw new NedostatokParametrov(this);
        }

        else if(((from instanceof Prechod)&&(to instanceof Prechod))||((from instanceof Miesto)&&(to instanceof Miesto))){
            throw new HranaNotCreatable(this);
        }else if((weight<1)&&!(this instanceof ResetHrana)){
            throw new NotEnoughWeight(this);

        }

        else{
            this.from = from;
            this.to = to;
            this.weight = weight;
            this.id=id;
            System.out.println("Vytvrotil som hranu s ID "+this.getId());
        }
    }

     public void connectParts(PrvokSiete from,PrvokSiete to){

         from.addOutgoing(this);
        to.addIncoming(this);

     }




    public PrvokSiete getFrom() {
        return from;
    }

    public void setFrom(PrvokSiete from) {
        this.from = from;
    }

    public PrvokSiete getTo() {
        return to;
    }

    public void setTo(PrvokSiete to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
