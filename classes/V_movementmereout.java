package object;
import java.sql.Date;

public class V_movementmereout{

    int idmovementmereout; 
    int idmagasin; 
    int idarticle; 
    double quantite; 
    Date dateout; 
    int etat; 
    int idunitarticleorigine; 
    String unitname; 
    String nommagasin; 
    String codearticle; 

    public V_movementmereout(){}

    public int getIdmovementmereout(){
        return this.idmovementmereout;
    }
    public void setIdmovementmereout(int idmovementmereout){
        this.idmovementmereout=idmovementmereout;
    }
    public int getIdmagasin(){
        return this.idmagasin;
    }
    public void setIdmagasin(int idmagasin){
        this.idmagasin=idmagasin;
    }
    public int getIdarticle(){
        return this.idarticle;
    }
    public void setIdarticle(int idarticle){
        this.idarticle=idarticle;
    }
    public double getQuantite(){
        return this.quantite;
    }
    public void setQuantite(double quantite){
        this.quantite=quantite;
    }
    public Date getDateout(){
        return this.dateout;
    }
    public void setDateout(Date dateout){
        this.dateout=dateout;
    }
    public int getEtat(){
        return this.etat;
    }
    public void setEtat(int etat){
        this.etat=etat;
    }
    public int getIdunitarticleorigine(){
        return this.idunitarticleorigine;
    }
    public void setIdunitarticleorigine(int idunitarticleorigine){
        this.idunitarticleorigine=idunitarticleorigine;
    }
    public String getUnitname(){
        return this.unitname;
    }
    public void setUnitname(String unitname){
        this.unitname=unitname;
    }
    public String getNommagasin(){
        return this.nommagasin;
    }
    public void setNommagasin(String nommagasin){
        this.nommagasin=nommagasin;
    }
    public String getCodearticle(){
        return this.codearticle;
    }
    public void setCodearticle(String codearticle){
        this.codearticle=codearticle;
    }

}
