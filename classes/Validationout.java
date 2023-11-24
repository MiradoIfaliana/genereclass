package object;
import java.sql.Date;

public class Validationout{

    int idvalidationout; 
    int idmovementmereout; 
    Date datevalidation; 

    public Validationout(){}

    public int getIdvalidationout(){
        return this.idvalidationout;
    }
    public void setIdvalidationout(int idvalidationout){
        this.idvalidationout=idvalidationout;
    }
    public int getIdmovementmereout(){
        return this.idmovementmereout;
    }
    public void setIdmovementmereout(int idmovementmereout){
        this.idmovementmereout=idmovementmereout;
    }
    public Date getDatevalidation(){
        return this.datevalidation;
    }
    public void setDatevalidation(Date datevalidation){
        this.datevalidation=datevalidation;
    }

}
