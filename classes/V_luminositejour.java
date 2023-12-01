package com.example.demo.Models;
import java.sql.Date;
import java.sql.Time;

public class V_luminositejour{

    int idluminositejour; 
    int dayofweek; 
    Date dateluminosite; 
    Time heureenergie; 
    double niveauluminosite; 

    public V_luminositejour(){}

    public int getIdluminositejour(){
        return this.idluminositejour;
    }
    public void setIdluminositejour(int idluminositejour){
        this.idluminositejour=idluminositejour;
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

}
