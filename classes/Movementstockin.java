package object;
import java.sql.Date;

public class Movementstockin{

    int idmovementstockin; 
    int idarticle; 
    int idmagasin; 
    double quantiteinitial; 
    double prixunit; 
    Date datein; 
    int idunitarticle; 

    public Movementstockin(){}

    public int getIdmovementstockin(){
        return this.idmovementstockin;
    }
    public void setIdmovementstockin(int idmovementstockin){
        this.idmovementstockin=idmovementstockin;
    }
    public int getIdarticle(){
        return this.idarticle;
    }
    public void setIdarticle(int idarticle){
        this.idarticle=idarticle;
    }
    public int getIdmagasin(){
        return this.idmagasin;
    }
    public void setIdmagasin(int idmagasin){
        this.idmagasin=idmagasin;
    }
    public double getQuantiteinitial(){
        return this.quantiteinitial;
    }
    public void setQuantiteinitial(double quantiteinitial){
        this.quantiteinitial=quantiteinitial;
    }
    public double getPrixunit(){
        return this.prixunit;
    }
    public void setPrixunit(double prixunit){
        this.prixunit=prixunit;
    }
    public Date getDatein(){
        return this.datein;
    }
    public void setDatein(Date datein){
        this.datein=datein;
    }
    public int getIdunitarticle(){
        return this.idunitarticle;
    }
    public void setIdunitarticle(int idunitarticle){
        this.idunitarticle=idunitarticle;
    }

}
