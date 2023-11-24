package object;
import java.sql.Date;

public class Personne{

    int id; 
    String nom; 
    String prenom; 
    Date date_naissance; 
    Date date_embauche; 
    String adresse; 
    String email; 

    public Personne(){}

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public Date getDate_naissance(){
        return this.date_naissance;
    }
    public void setDate_naissance(Date date_naissance){
        this.date_naissance=date_naissance;
    }
    public Date getDate_embauche(){
        return this.date_embauche;
    }
    public void setDate_embauche(Date date_embauche){
        this.date_embauche=date_embauche;
    }
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse=adresse;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }

}
