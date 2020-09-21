package com.company.xmlContext;

import com.company.Hrany.HranaSiete;
import com.company.Hrany.ResetHrana;
import com.company.Petrinet;
import com.company.Prvky.Miesto;
import com.company.Prvky.Prechod;
import com.company.graphics.Elements;
import sun.print.DialogOwner;

import java.util.ArrayList;
import java.util.List;

public class TransformDoc {
    //
    Petrinet petrinet = new Petrinet();
    public Document transform_Dokument(Petrinet petrinet){
        this.petrinet=petrinet;
        Document document = new Document();
        document.setTransition(getMyTranstions());
        document.setPlace(getMyPlaces());
        document.setArc(getMyArcs());
        return document;
    }


    private List<Arc> getMyArcs(){
        List<HranaSiete> hrany = this.petrinet.getHrany();
        List<Arc> documentArcs=new ArrayList<>();
        for(HranaSiete hrana:hrany){
            Arc documentArc = new Arc();
            documentArc.setId((int)hrana.getId());
            documentArc.setMultiplicity(hrana.getWeight());
            documentArc.setSourceId((int)hrana.getFrom().getId());
            documentArc.setDestinationId((int)hrana.getTo().getId());
            if(hrana instanceof ResetHrana){
                documentArc.setType(ArcType.RESET);
            }else{
                documentArc.setType(ArcType.REGULAR);
            }

            documentArcs.add(documentArc);


        }
        return documentArcs;

    }

    private List<Place>getMyPlaces(){
        List<Miesto> miesta = this.petrinet.getMiesta();
        List<Place> documentPlaces=new ArrayList<>();
        for(Miesto miesto:miesta){
            Place documentPlace = new Place();
            documentPlace.setId((int)miesto.getId());
            documentPlace.setTokens(miesto.getTokens());
            documentPlace.setLabel(miesto.getName());
            documentPlace.setX(miesto.getX());
            documentPlace.setY(miesto.getY());
            documentPlaces.add(documentPlace);

        }
        return documentPlaces;
    }

    private List<Transition>getMyTranstions(){
        List<Prechod> prechody = this.petrinet.getPrechody();
        List<Transition> documentTransitions = new ArrayList<>();
        for(Prechod prechod:prechody){
            Transition documentTransition = new Transition();
            documentTransition.setId((int)prechod.getId());
            documentTransition.setLabel(prechod.getName());
            documentTransition.setX(prechod.getX());
            documentTransition.setY(prechod.getY());
            documentTransitions.add(documentTransition);

        }

    return documentTransitions;
    }

}
