package com.company.siete;

import com.company.Hrany.HranaSiete;
import com.company.Hrany.ResetHrana;
import com.company.MyExceptions.HranaNotCreatable;
import com.company.MyExceptions.NotEnoughWeight;
import com.company.MyExceptions.SameIDExceprion;
import com.company.Petrinet;
import com.company.Prvky.Miesto;
import com.company.Prvky.Prechod;

public class siet1 extends Petrinet {

    public Miesto m1=new Miesto();
    public Miesto m2=new Miesto();
    public Miesto m3=new Miesto();
    public Miesto m4=new Miesto();
    public Prechod p1=new Prechod();
    public HranaSiete h1;
    public HranaSiete h2;
    public HranaSiete h3;
    public ResetHrana h4;


    public siet1() {
    }

    public void setup(){


        m1.setId(1);
        m1.setTokens(1);
        try {
            this.addMiesto(m1);
        }catch (SameIDExceprion e){
            System.out.println("Nie he mozne vytvorit miesto m1");
        }


        m2.setId(2);
        m2.setTokens(5);
        try {
            this.addMiesto(m2);
        }catch (SameIDExceprion e){
            System.out.println("Nie he mozne vytvorit miesto m2");
        }

        m3.setId(3);
        m3.setTokens(0);
        try {
            this.addMiesto(m3);
        }catch (SameIDExceprion e){
            System.out.println("Nie he mozne vytvorit miesto m3");
        }


        m4.setId(4);
        m4.setTokens(0);
        try {
            this.addMiesto(m4);
        }catch (SameIDExceprion e){
            System.out.println("Nie he mozne vytvorit miesto m1");
        }






        p1.setId(5);
        try {
            this.addPrechod(p1);
        }catch (SameIDExceprion e){
            System.out.println("Nie he mozne vytvorit prechod p1");
        }




        try {
            h1=new HranaSiete(6,m1,p1,1);
        }catch (Exception e){
            System.out.println("Nie he mozne vytvorit hranu h1");
        }
        h1.setId(6);
        h1.connectParts(m1,p1);
        try {
            this.addHrana(h1);
        }catch (SameIDExceprion e){
            System.out.println("Nie he mozne vytvorit hranu h1");
        }

        try {
            h2=new HranaSiete(7,p1,m3,1);
        }catch (Exception e) {
            System.out.println("Nie he mozne vytvorit hranu h2");
        }
        h2.setId(7);

        h2.connectParts(p1,m3);
        try {
            this.addHrana(h2);
        }catch (SameIDExceprion e){
            System.out.println("Nie he mozne vytvorit hranu h2");
        }


        try {
            h3=new HranaSiete(8,p1,m4,1);
        }catch (Exception e) {
            System.out.println("Nie he mozne vytvorit hranu h3");
        }
        h3.setId(8);

        h3.connectParts(p1,m4);
        try {
            this.addHrana(h3);
        }catch (SameIDExceprion e){
            System.out.println("Nie he mozne vytvorit hranu h3");
        }


        try {
            h4=new ResetHrana(9,m2,p1,480);
        }catch (Exception e) {
            System.out.println("Nie he mozne vytvorit hranu h4");
        }
        h4.setId(9);

        h4.connectParts(m2,p1);
        try {
            this.addHrana(h4);
        }catch (SameIDExceprion e){
            System.out.println("Nie he mozne vytvorit hranu h4");
        }


    }



}
