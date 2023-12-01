package com.example.demo.Models;
import java.sql.Date;

public class V_secteuretudiant{

    int idsecteur; 
    String nomsecteur; 
    Date datecount; 
    long nbmatin; 
    long nbmidi; 

    public V_secteuretudiant(){}

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
    public Date getDatecount(){
        return this.datecount;
    }
    public void setDatecount(Date datecount){
        this.datecount=datecount;
    }
    public long getNbmatin(){
        return this.nbmatin;
    }
    public void setNbmatin(long nbmatin){
        this.nbmatin=nbmatin;
    }
    public long getNbmidi(){
        return this.nbmidi;
    }
    public void setNbmidi(long nbmidi){
        this.nbmidi=nbmidi;
    }

}
