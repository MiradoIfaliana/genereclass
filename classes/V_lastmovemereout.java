package object;
import java.sql.Date;

public class V_lastmovemereout{

    int idmovementmereout; 
    int idmagasin; 
    int idarticle; 
    double quantite; 
    Date dateout; 
    int etat; 
    Date datevalidation; 

    public V_lastmovemereout(){}

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
    public Date getDatevalidation(){
        return this.datevalidation;
    }
    public void setDatevalidation(Date datevalidation){
        this.datevalidation=datevalidation;
    }

}
