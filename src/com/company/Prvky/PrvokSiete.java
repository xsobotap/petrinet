package com.company.Prvky;

import com.company.Hrany.HranaSiete;

import javax.xml.ws.handler.HandlerResolver;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public abstract class PrvokSiete {
    int x;
    int y;

    int tokens;
    boolean hasTokens;
    List<HranaSiete> incoming=new ArrayList<HranaSiete>();
    List<HranaSiete> outgoing=new ArrayList<HranaSiete>();
    String name;
    long id;

    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        System.out.println("Tokeny pre miesto "+this.getId()+" boli vynulovane");
        this.tokens = tokens;
    }

    public boolean isHasTokens() {
        return hasTokens;
    }

    public void setHasTokens(boolean hasTokens) {
        this.hasTokens = hasTokens;
    }

    public List<HranaSiete> getIncoming() {
        return incoming;
    }

    public void addIncoming(HranaSiete hrana){
        incoming.add(hrana);

    }

    public void addOutgoing(HranaSiete hrana){
        outgoing.add(hrana);
    }

    public void setIncoming(List<HranaSiete> incoming) {
        this.incoming = incoming;
    }

    public List<HranaSiete> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(List<HranaSiete> outgoing) {
        this.outgoing = outgoing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
