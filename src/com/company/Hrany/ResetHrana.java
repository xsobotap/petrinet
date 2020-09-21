package com.company.Hrany;

import com.company.MyExceptions.HranaNotCreatable;
import com.company.MyExceptions.NedostatokParametrov;
import com.company.MyExceptions.NotEnoughWeight;
import com.company.Prvky.Miesto;
import com.company.Prvky.Prechod;
import com.company.Prvky.PrvokSiete;
import com.sun.xml.internal.ws.policy.jaxws.SafePolicyReader;

import javax.naming.ldap.PagedResultsControl;

public class ResetHrana extends HranaSiete {
    //private PrvokSiete from;
    //private PrvokSiete to;
    //private long id;



    public ResetHrana(long id,PrvokSiete from, PrvokSiete to,int weight) throws HranaNotCreatable,NotEnoughWeight, NedostatokParametrov {
        super(id,from,to,weight);
        if((from==null)||(to==null)){
            throw new NedostatokParametrov(this);
        }
        else if(((from instanceof Prechod)&&(to instanceof Miesto))
                || ((from instanceof Prechod)&&(to instanceof Prechod))
                ||((from instanceof Miesto)&&(to instanceof Miesto))){
            throw new HranaNotCreatable(this);

        }
        else
        {
            this.from = from;
            this.to=to;
            this.id=id;
            this.weight=0;
        }
    }
}
