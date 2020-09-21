package com.company.graphics;

import com.company.Hrany.HranaSiete;
import com.company.Hrany.ResetHrana;
import com.company.MyExceptions.SameIDExceprion;
import com.company.Petrinet;
import com.company.Prvky.Miesto;
import com.company.Prvky.Prechod;
import com.company.Prvky.PrvokSiete;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class NetCanvas extends Canvas implements MouseListener {

    int typeOfAction;
    int pocetKlikovPreHranu = 0;
    PrvokSiete from;
    PrvokSiete to;
    int id=0;
    int bolaista=0;
    Elements naVymazanie;


    public void setTypeOfAction(int typeOfAction) {
        this.typeOfAction = typeOfAction;
    }

    private List<Elements> elements = new LinkedList<>();

    Petrinet petrinet=new Petrinet();

    public void setPetrinet(Petrinet petrinet) {
        this.petrinet = petrinet;
    }

    public Petrinet getPetrinet() {
        return petrinet;
    }

    public NetCanvas(Petrinet petrinet){
        super();
        this.elements = new LinkedList<>();
        this.petrinet=petrinet;

    }

    public void vlozElement(Elements element){
        this.elements.add(element);

    }

    @Override
    public void paint(Graphics g){

        for(Elements el:elements){
            el.draw(g);
        }
    }

/*
*
*                       VSETKY POTREBNE METODY PRE ZMENU VYKRESLOVANIA
*                       PREBIEHAJU V METODE MOUSECLICKED
*
* */



    @Override
    public void mouseClicked(MouseEvent e) {
        Rectangle2D rectangle2D= new Rectangle2D.Double(e.getX()-10,e.getY()-10,20,20);
        System.out.println("klik");
        if(typeOfAction==5){

            for (Elements p : elements) {
            if (p instanceof Stvorec) {
                if (((p.getX() <= e.getX()) && (p.getX() + 40 > e.getX())) && ((p.getY() <= e.getY()) && (p.getY() + 40 > e.getY()))) {


                    System.out.println("klikol som na prechod");
                    try {
                        ((Stvorec) p).getPrechod().run();
                    } catch (Exception a) {
                        System.out.println("nemozne spustit prechod");

                    }


                    for (Elements m : elements) {
                        if (m instanceof Kruh) {

                            for (HranaSiete h : ((Stvorec) p).getPrechod().getIncoming()) {
                                if (((Kruh) m).getId() == h.getFrom().getId()) {
                                    ((Kruh) m).setTokens(h.getFrom().getTokens());
                                }

                            }
                            for (HranaSiete h : ((Stvorec) p).getPrechod().getOutgoing()) {
                                if (((Kruh) m).getId() == h.getTo().getId()) {
                                    ((Kruh) m).setTokens(h.getTo().getTokens());
                                }

                            }
                        }

                    }


                }

            }

            if(p instanceof Kruh){
                if (((p.getX() <= e.getX()) && (p.getX() + 40 > e.getX())) && ((p.getY() <= e.getY()) && (p.getY() + 40 > e.getY()))) {
                    if(e.getButton() == MouseEvent.BUTTON1) {
                        ((Kruh) p).getMiesto().setTokens(((Kruh) p).getMiesto().getTokens()+1);
                        ((Kruh) p).setTokens(((Kruh) p).getTokens()+1);
                    }
                    if((e.getButton() == MouseEvent.BUTTON3)&&(((Kruh) p).getTokens()>0)) {
                        ((Kruh) p).getMiesto().setTokens(((Kruh) p).getMiesto().getTokens()-1);
                        ((Kruh) p).setTokens(((Kruh) p).getTokens()-1);

                    }
                }
            }

            if((p instanceof Usecka)&&(((Usecka) p).getVaha()!=0)){


                Line2D l1 = new Line2D.Double(((Usecka) p).getFrom().getX(),((Usecka) p).getFrom().getY(),((Usecka) p).getTo().getX(),((Usecka) p).getTo().getY());

                if(rectangle2D.intersectsLine(l1)){
                    if(e.getButton() == MouseEvent.BUTTON1) {
                        ((Usecka) p).setVaha(((Usecka) p).getVaha() + 1);
                        ((Usecka) p).getHranaSiete().setWeight(((Usecka) p).getHranaSiete().getWeight()+1);
                    }
                    if((e.getButton() == MouseEvent.BUTTON3)&&(((Usecka) p).getVaha()>1)) {
                        ((Usecka) p).setVaha(((Usecka) p).getVaha() -1);
                        ((Usecka) p).getHranaSiete().setWeight(((Usecka) p).getHranaSiete().getWeight()-1);

                    }
                }


            }
            repaint();
            //break;
        }
    }
    if(typeOfAction==1){



            try {
                if(this.elements!=null){
                    id++;
                }
                Miesto miesto =new Miesto();//this.elements.get(elements.size()-1).getId()+1

                miesto.setX(e.getX());
                miesto.setY(e.getY());
                miesto.setId(id);
                miesto.setTokens(0);


            this.petrinet.addMiesto(miesto);
                Kruh kruh =new Kruh(e.getX(),e.getY(),0,"",id);
                this.vlozElement(kruh);
                kruh.setMiesto(miesto);
                repaint();

        }catch (SameIDExceprion ee){
            System.out.println("treba nove id");


        }






    }

    if(typeOfAction==2){

            try {
                if(this.elements!=null){
                    id++;
                }
                Prechod prechod =new Prechod();//this.elements.get(elements.size()-1).getId()+1
                Stvorec stvorec = new Stvorec(e.getX(),e.getY(),prechod.isRunnable(),prechod.getName(),id,prechod);
                prechod.setX(e.getX());
                prechod.setY(e.getY());
                prechod.setId(id);
                stvorec.setPrechod(prechod);
                this.petrinet.addPrechod(prechod);
                this.vlozElement(stvorec);
                repaint();

            }catch (SameIDExceprion ee){
                System.out.println("treba nove id");


            }




    }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX      HRANA       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxx

    if(typeOfAction==3){
        pocetKlikovPreHranu++;
        if(pocetKlikovPreHranu==1) {


             this.from=null;
            this.to=null;


            System.out.println("pocet klikov"+pocetKlikovPreHranu);
            System.out.println("zbehla prva podmienka");


            for (Elements p : elements) {
                if ((p instanceof Stvorec) || (p instanceof Kruh)) {
                    if (((p.getX() <= e.getX()) && (p.getX() + 40 > e.getX())) && ((p.getY() <= e.getY()) && (p.getY() + 40 > e.getY()))) {
                        if(p instanceof Stvorec){
                            this.from = ((Stvorec) p).getPrechod();
                        }
                        if(p instanceof Kruh){
                            this.from = ((Kruh)p).getMiesto();
                        }
                        System.out.println("vzbral som from"+this.from   );

                    }
                }
            }

        }
        if(pocetKlikovPreHranu==2) {
            bolaista=0;
            System.out.println("pocet klikov "+pocetKlikovPreHranu);

            for (Elements p : elements) {
                if ((p instanceof Stvorec) || (p instanceof Kruh)) {
                    if (((p.getX() <= e.getX()) && (p.getX() + 40 > e.getX())) && ((p.getY() <= e.getY()) && (p.getY() + 40 > e.getY()))) {
                        if(p instanceof Stvorec){
                            this.to = ((Stvorec) p).getPrechod();
                        }
                        if(p instanceof Kruh){
                            this.to = ((Kruh)p).getMiesto();
                        }
                        System.out.println("vzbral som to"+this.to);

                    }
                }
            }

            System.out.println("from "+this.from+"to "+this.to );

                try {
                    HranaSiete hranaSiete = new HranaSiete(id,this.from,this.to,1);
                    hranaSiete.connectParts(this.from,this.to);
                    Usecka usecka = new Usecka(0, 0, hranaSiete.getFrom(), hranaSiete.getTo(), hranaSiete.getWeight());
                    hranaSiete.setElement(usecka);
                    usecka.setHranaSiete(hranaSiete);
                    this.vlozElement(usecka);



                    petrinet.addHrana(hranaSiete);
                    System.out.println("vaha hrany je"+hranaSiete.getWeight());

                    }


                 catch (SameIDExceprion ee){
                    System.out.println("treba nove id");


                }
                catch (Exception ee) {
                    System.out.println("hranu nemozlive vtvorit");

                }

        repaint();
            pocetKlikovPreHranu=0;
        }


//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX      RESET HRANA       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxx
    }

        if(typeOfAction==4){
            pocetKlikovPreHranu++;
            if(pocetKlikovPreHranu==1) {


                this.from=null;
                this.to=null;


                System.out.println("pocet klikov"+pocetKlikovPreHranu);
                System.out.println("zbehla prva podmienka");


                for (Elements p : elements) {
                    if ((p instanceof Stvorec) || (p instanceof Kruh)) {
                        if (((p.getX() <= e.getX()) && (p.getX() + 40 > e.getX())) && ((p.getY() <= e.getY()) && (p.getY() + 40 > e.getY()))) {
                            if(p instanceof Stvorec){
                                this.from = ((Stvorec) p).getPrechod();
                            }
                            if(p instanceof Kruh){
                                this.from = ((Kruh)p).getMiesto();
                            }
                            System.out.println("vzbral som from"+this.from   );

                        }
                    }
                }

            }
            if(pocetKlikovPreHranu==2) {
                bolaista=0;
                System.out.println("pocet klikov "+pocetKlikovPreHranu);

                for (Elements p : elements) {
                    if ((p instanceof Stvorec) || (p instanceof Kruh)) {
                        if (((p.getX() <= e.getX()) && (p.getX() + 40 > e.getX())) && ((p.getY() <= e.getY()) && (p.getY() + 40 > e.getY()))) {
                            if(p instanceof Stvorec){
                                this.to = ((Stvorec) p).getPrechod();
                            }
                            if(p instanceof Kruh){
                                this.to = ((Kruh)p).getMiesto();
                            }
                            System.out.println("vzbral som to"+this.to);

                        }
                    }
                }

                System.out.println("from "+this.from+"to "+this.to );

                try {

                    ResetHrana resetHrana = new ResetHrana(id,this.from,this.to,0);
                    resetHrana.connectParts(this.from,this.to);

                    Usecka usecka = new Usecka(0, 0, resetHrana.getFrom(), resetHrana.getTo(), resetHrana.getWeight());
                    resetHrana.setElement(usecka);
                    usecka.setHranaSiete(resetHrana);
                    this.vlozElement(usecka);



                    petrinet.addHrana(resetHrana);
                    System.out.println("vaha hrany je"+resetHrana.getWeight());

                }


                catch (SameIDExceprion ee){
                    System.out.println("treba nove id");


                }
                catch (Exception ee) {
                    System.out.println("hranu nemozlive vtvorit");

                }

                repaint();
                pocetKlikovPreHranu=0;
            }



        }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxxxxxxx     DELETE     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        //
        //                               Vyskytuju sa tu problemy kedy vymazavam zo zoznamu ktory iterujem
        //                                  Inak to ale neviem vyriesit
        //
        //
        if(typeOfAction==6){


            for(Elements p:elements) {
                if((p instanceof Stvorec)||(p instanceof Kruh)){
                if (((p.getX() <= e.getX()) && (p.getX() + 40 > e.getX())) && ((p.getY() <= e.getY()) && (p.getY() + 40 > e.getY()))) {
                        naVymazanie = p;
                        this.elements.remove(p);

                    }
                }else if(p instanceof Usecka){
                    Line2D l1 = new Line2D.Double(((Usecka) p).getFrom().getX(),((Usecka) p).getFrom().getY(),((Usecka) p).getTo().getX(),((Usecka) p).getTo().getY());
                    if(rectangle2D.intersectsLine(l1)) {
                        for (HranaSiete hrana : this.petrinet.getHrany()) {
                            if (((Usecka) p).getHranaSiete() == hrana) {

                                for(HranaSiete hrana2:hrana.getFrom().getOutgoing()){
                                    if(hrana2==hrana){
                                        hrana.getFrom().getOutgoing().remove(hrana2);
                                        hrana2=null;
                                        break;
                                    }

                                }

                                for(HranaSiete hrana2:hrana.getTo().getIncoming()){
                                    if(hrana2==hrana){
                                        hrana.getTo().getIncoming().remove(hrana2);
                                        hrana2=null;
                                        break;
                                    }

                                }




                                this.petrinet.getHrany().remove(hrana);
                                this.elements.remove(hrana.getElement());
                                hrana = null;
                            }
                        break;
                        }

                    }

                }
            }
            if(naVymazanie instanceof Stvorec){
                for(Prechod prechod:this.petrinet.getPrechody()){
                    if(((Stvorec) naVymazanie).getPrechod()==prechod){

                        for(HranaSiete hrana:prechod.getIncoming()){
                            this.petrinet.getHrany().remove(hrana);
                            this.elements.remove(hrana.getElement());
                            hrana=null;

                        }
                        for(HranaSiete hrana:prechod.getOutgoing()){
                            this.petrinet.getHrany().remove(hrana);
                            this.elements.remove(hrana.getElement());
                            hrana=null;

                        }

                        prechod=null;



                    }

                }
            }

            if(naVymazanie instanceof Kruh){
                for(Miesto miesto:this.petrinet.getMiesta()){
                    if(((Kruh) naVymazanie).getMiesto()==miesto){
                        this.petrinet.getMiesta().remove(miesto);

                        for(HranaSiete hrana:miesto.getIncoming()){
                            this.petrinet.getHrany().remove(hrana);
                            this.elements.remove(hrana.getElement());
                            hrana=null;


                        }
                        for(HranaSiete hrana:miesto.getOutgoing()){
                            this.petrinet.getHrany().remove(hrana);
                            this.elements.remove(hrana.getElement());
                            hrana=null;


                        }

                        miesto=null;
                        break;

                    }

                }
            }

                repaint();
            }





    for(Elements p:this.elements) {
        if(p instanceof Stvorec) {
            if (((Stvorec) p).getPrechod().isRunnable() == false) {
                ((Stvorec) p).setRunning(false);
            } else {
                ((Stvorec) p).setRunning(true);
            }
        }
    }



    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
