package com.example.demo.Models;
import java.sql.Date;

public class Nombreetudiant{

    int idnombreetudiant; 
    int idsalle; 
    long nombre; 
    Date datecount; 
    int matinoumidi; 

    public Nombreetudiant(){}

    public int getIdnombreetudiant(){
        return this.idnombreetudiant;
    }
    public void setIdnombreetudiant(int idnombreetudiant){
        this.idnombreetudiant=idnombreetudiant;
    }
    public int getIdsalle(){
        return this.idsalle;
    }
    public void setIdsalle(int idsalle){
        this.idsalle=idsalle;
    }
    public long getNombre(){
        return this.nombre;
    }
    public void setNombre(long nombre){
        this.nombre=nombre;
    }
    public Date getDatecount(){
        return this.datecount;
    }
    public void setDatecount(Date datecount){
        this.datecount=datecount;
    }
    public int getMatinoumidi(){
        return this.matinoumidi;
    }
    public void setMatinoumidi(int matinoumidi){
        this.matinoumidi=matinoumidi;
    }

}
