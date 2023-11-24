package object;
import java.sql.Date;

public class V_movementstockoutvalide{

    int idmovementstockout; 
    int idmovementmereout; 
    int idmovementstockin; 
    double quantiteout; 
    int idmagasin; 
    int idarticle; 
    Date dateout; 
    int etat; 
    Date datevalidation; 

    public V_movementstockoutvalide(){}

    public int getIdmovementstockout(){
        return this.idmovementstockout;
    }
    public void setIdmovementstockout(int idmovementstockout){
        this.idmovementstockout=idmovementstockout;
    }
    public int getIdmovementmereout(){
        return this.idmovementmereout;
    }
    public void setIdmovementmereout(int idmovementmereout){
        this.idmovementmereout=idmovementmereout;
    }
    public int getIdmovementstockin(){
        return this.idmovementstockin;
    }
    public void setIdmovementstockin(int idmovementstockin){
        this.idmovementstockin=idmovementstockin;
    }
    public double getQuantiteout(){
        return this.quantiteout;
    }
    public void setQuantiteout(double quantiteout){
        this.quantiteout=quantiteout;
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
