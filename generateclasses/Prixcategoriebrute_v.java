package entite;

public class Prixcategoriebrute_v{
    int idcategorie; 
    int idstyle; 
    int idtaille; 
    double prixtotal; 

    public Prixcategoriebrute_v(){ }
    
    public int getIdcategorie(){
        return this.idcategorie;
    }
    public void setIdcategorie(int idcategorie){
        this.idcategorie=idcategorie;
    }
    public int getIdstyle(){
        return this.idstyle;
    }
    public void setIdstyle(int idstyle){
        this.idstyle=idstyle;
    }
    public int getIdtaille(){
        return this.idtaille;
    }
    public void setIdtaille(int idtaille){
        this.idtaille=idtaille;
    }
    public double getPrixtotal(){
        return this.prixtotal;
    }
    public void setPrixtotal(double prixtotal){
        this.prixtotal=prixtotal;
    }

}
