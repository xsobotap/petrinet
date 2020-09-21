package com.company.xmlContext;

import com.company.Petrinet;

import java.sql.SQLOutput;
import java.util.ArrayList;

//z xml documentu bude prechaydat dokuent a bude v nasom petrinete bude nacitavat y dokumentu
public class TransformNet extends Transform<Petrinet> {
    @Override
    public Petrinet transform(Document document) {
        Petrinet net = new Petrinet();

        for(Place place: document.getPlace()){
            com.company.Prvky.Miesto miesto= new com.company.Prvky.Miesto();

            miesto.setTokens(place.getTokens());
            miesto.setId(place.getId());
            miesto.setName(place.getLabel());
            miesto.setX(place.getX());
            miesto.setY(place.getY());

            try {
                net.addMiesto(miesto);
            }catch (Exception e){
                System.out.println();
            }

        }

        for(Transition transition: document.getTransition()){
            com.company.Prvky.Prechod prechod = new com.company.Prvky.Prechod();

            prechod.setName(transition.getLabel());
            prechod.setId(transition.getId());
            prechod.setX(transition.getX());
            prechod.setY(transition.getY());


            try {
                net.addPrechod(prechod);
            }catch (Exception e){
                System.out.println();
            }


        }
        //predpoklad ye si najprv vloyome do siete vsetkz precjodz a miesta a ay potom hrany
        for(Arc arc:document.getArc()){
            com.company.Prvky.PrvokSiete from=null;
            com.company.Prvky.PrvokSiete to=null;

            for(com.company.Prvky.Miesto m: net.getMiesta() )
            {
                if(m.getId()==arc.getSourceId()){
                    from=m;

                }

                if(m.getId()==arc.getDestinationId()){
                    to=m;
                }

            }

            for(com.company.Prvky.Prechod p: net.getPrechody()){
                if(p.getId()==arc.getSourceId()){
                    from=p;

                }

                if(p.getId()==arc.getDestinationId()){
                    to=p;
                }



            }


            if(arc.type==ArcType.REGULAR){
             try {
                 com.company.Hrany.HranaSiete hranaSiete = new com.company.Hrany.HranaSiete(
                         arc.getId(),
                         from,
                         to,
                         arc.getMultiplicity()

                         );
                 hranaSiete.connectParts(from,to);
                 net.addHrana(hranaSiete);
             }catch (Exception e){
                 System.out.println("Niekde nastala chyba ");
             }


            }

            if(arc.type==ArcType.RESET){
                try {
                    com.company.Hrany.ResetHrana hranaSiete = new com.company.Hrany.ResetHrana(
                            arc.getId(),
                            from,
                            to,
                            arc.getMultiplicity()

                    );
                    hranaSiete.connectParts(from,to);
                    net.addHrana(hranaSiete);
                }catch (Exception e){
                    System.out.println("Niekde nastala chyba ");
                }


            }


        }

        return net;
    }






}
