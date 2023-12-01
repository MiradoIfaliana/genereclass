package com.example.demo.Models;
import java.sql.Date;
import java.sql.Time;

public class Luminositejour{

    int idluminositejour; 
    double niveauluminosite; 
    Date dateluminosite; 
    Time heureenergie; 

    public Luminositejour(){}

    public int getIdluminositejour(){
        return this.idluminositejour;
    }
    public void setIdluminositejour(int idluminositejour){
        this.idluminositejour=idluminositejour;
    }
    public double getNiveauluminosite(){
        return this.niveauluminosite;
    }
    public void setNiveauluminosite(double niveauluminosite){
        this.niveauluminosite=niveauluminosite;
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

}
