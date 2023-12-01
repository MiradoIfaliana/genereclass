package com.example.demo.Models;

public class V_secteurpanneaubatteriew{

    int idsecteur; 
    String nomsecteur; 
    double panneaumaxw; 
    double batteriemaxw; 

    public V_secteurpanneaubatteriew(){}

    public int getIdsecteur(){
        return this.idsecteur;
    }
    public void setIdsecteur(int idsecteur){
        this.idsecteur=idsecteur;
    }
    public String getNomsecteur(){
        return this.nomsecteur;
    }
    public void setNomsecteur(String nomsecteur){
        this.nomsecteur=nomsecteur;
    }
    public double getPanneaumaxw(){
        return this.panneaumaxw;
    }
    public void setPanneaumaxw(double panneaumaxw){
        this.panneaumaxw=panneaumaxw;
    }
    public double getBatteriemaxw(){
        return this.batteriemaxw;
    }
    public void setBatteriemaxw(double batteriemaxw){
        this.batteriemaxw=batteriemaxw;
    }

}
