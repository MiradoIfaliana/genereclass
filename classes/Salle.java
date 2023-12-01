package com.example.demo.Models;

public class Salle{

    int idsalle; 
    String nomsale; 
    int idsecteur; 

    public Salle(){}

    public int getIdsalle(){
        return this.idsalle;
    }
    public void setIdsalle(int idsalle){
        this.idsalle=idsalle;
    }
    public String getNomsale(){
        return this.nomsale;
    }
    public void setNomsale(String nomsale){
        this.nomsale=nomsale;
    }
    public int getIdsecteur(){
        return this.idsecteur;
    }
    public void setIdsecteur(int idsecteur){
        this.idsecteur=idsecteur;
    }

}
