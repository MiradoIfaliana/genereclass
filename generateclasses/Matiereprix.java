package entite;
import java.sql.Date;

public class Matiereprix{
    int idmatiereprix; 
    int idmatiere; 
    double prix; 
    Date dateprix; 

    public Matiereprix(){ }
    
    public int getIdmatiereprix(){
        return this.idmatiereprix;
    }
    public void setIdmatiereprix(int idmatiereprix){
        this.idmatiereprix=idmatiereprix;
    }
    public int getIdmatiere(){
        return this.idmatiere;
    }
    public void setIdmatiere(int idmatiere){
        this.idmatiere=idmatiere;
    }
    public double getPrix(){
        return this.prix;
    }
    public void setPrix(double prix){
        this.prix=prix;
    }
    public Date getDateprix(){
        return this.dateprix;
    }
    public void setDateprix(Date dateprix){
        this.dateprix=dateprix;
    }

}
