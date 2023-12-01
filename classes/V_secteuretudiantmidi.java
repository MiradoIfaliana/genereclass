package com.example.demo.Models;
import java.sql.Date;

public class V_secteuretudiantmidi{

    int idsecteur; 
    String nomsecteur; 
    Date datecount; 
    long nbetudiant; 

    public V_secteuretudiantmidi(){}

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
    public long getNbetudiant(){
        return this.nbetudiant;
    }
    public void setNbetudiant(long nbetudiant){
        this.nbetudiant=nbetudiant;
    }

}
