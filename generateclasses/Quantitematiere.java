package entite;

public class Quantitematiere{
    int idquantitematiere; 
    int idmatierestyle; 
    int idtaille; 
    double quantite; 
    int idcategorie; 

    public Quantitematiere(){ }
    
    public int getIdquantitematiere(){
        return this.idquantitematiere;
    }
    public void setIdquantitematiere(int idquantitematiere){
        this.idquantitematiere=idquantitematiere;
    }
    public int getIdmatierestyle(){
        return this.idmatierestyle;
    }
    public void setIdmatierestyle(int idmatierestyle){
        this.idmatierestyle=idmatierestyle;
    }
    public int getIdtaille(){
        return this.idtaille;
    }
    public void setIdtaille(int idtaille){
        this.idtaille=idtaille;
    }
    public double getQuantite(){
        return this.quantite;
    }
    public void setQuantite(double quantite){
        this.quantite=quantite;
    }
    public int getIdcategorie(){
        return this.idcategorie;
    }
    public void setIdcategorie(int idcategorie){
        this.idcategorie=idcategorie;
    }

}
