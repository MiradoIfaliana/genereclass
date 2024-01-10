package entite;

public class Prixcategorie_v{
    int idcategorie; 
    String nomcategorie; 
    int idstyle; 
    String nomstyle; 
    int idtaille; 
    String nomtaille; 
    double prixtotal; 

    public Prixcategorie_v(){ }
    
    public int getIdcategorie(){
        return this.idcategorie;
    }
    public void setIdcategorie(int idcategorie){
        this.idcategorie=idcategorie;
    }
    public String getNomcategorie(){
        return this.nomcategorie;
    }
    public void setNomcategorie(String nomcategorie){
        this.nomcategorie=nomcategorie;
    }
    public int getIdstyle(){
        return this.idstyle;
    }
    public void setIdstyle(int idstyle){
        this.idstyle=idstyle;
    }
    public String getNomstyle(){
        return this.nomstyle;
    }
    public void setNomstyle(String nomstyle){
        this.nomstyle=nomstyle;
    }
    public int getIdtaille(){
        return this.idtaille;
    }
    public void setIdtaille(int idtaille){
        this.idtaille=idtaille;
    }
    public String getNomtaille(){
        return this.nomtaille;
    }
    public void setNomtaille(String nomtaille){
        this.nomtaille=nomtaille;
    }
    public double getPrixtotal(){
        return this.prixtotal;
    }
    public void setPrixtotal(double prixtotal){
        this.prixtotal=prixtotal;
    }

}
