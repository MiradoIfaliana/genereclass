package com.example.demo.Models;
import java.sql.Date;
import java.sql.Time;

public class V_solaireexactjour{

    int idsecteur; 
    String nomsecteur; 
    double panneaumaxw; 
    int dayofweek; 
    Date dateluminosite; 
    Time heureenergie; 
    double niveauluminosite; 
    double capacitesolaire; 

    public V_solaireexactjour(){}

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
    public int getDayofweek(){
        return this.dayofweek;
    }
    public void setDayofweek(int dayofweek){
        this.dayofweek=dayofweek;
    }
    public Date getDateluminosite(){
        return this.dateluminosite;
    }
    public void setDateluminosite(Date dateluminosite){
        this.dateluminosite=dateluminosite;
    }
    public Time getHeureenergie(){
        return this.heureenergie;
    }
    public void setHeureenergie(Time heureenergie){
        this.heureenergie=heureenergie;
    }
    public double getNiveauluminosite(){
        return this.niveauluminosite;
    }
    public void setNiveauluminosite(double niveauluminosite){
        this.niveauluminosite=niveauluminosite;
    }
    public double getCapacitesolaire(){
        return this.capacitesolaire;
    }
    public void setCapacitesolaire(double capacitesolaire){
        this.capacitesolaire=capacitesolaire;
    }

}
