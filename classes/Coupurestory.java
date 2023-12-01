package com.example.demo.Models;
import java.sql.Date;
import java.sql.Time;

public class Coupurestory{

    int idcoupure; 
    int idsecteur; 
    Date datecoupure; 
    Time heurecoupure; 

    public Coupurestory(){}

    public int getIdcoupure(){
        return this.idcoupure;
    }
    public void setIdcoupure(int idcoupure){
        this.idcoupure=idcoupure;
    }
    public int getIdsecteur(){
        return this.idsecteur;
    }
    public void setIdsecteur(int idsecteur){
        this.idsecteur=idsecteur;
    }
    public Date getDatecoupure(){
        return this.datecoupure;
    }
    public void setDatecoupure(Date datecoupure){
        this.datecoupure=datecoupure;
    }
    public Time getHeurecoupure(){
        return this.heurecoupure;
    }
    public void setHeurecoupure(Time heurecoupure){
        this.heurecoupure=heurecoupure;
    }

}
