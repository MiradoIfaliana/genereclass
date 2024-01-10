package entite;

public class Matierequantite_v{
    int idcategorie; 
    String nomcategorie; 
    int idmatiere; 
    String nommatiere; 
    int idstyle; 
    String nomstyle; 
    int idtaille; 
    String nomtaille; 
    double quantite; 
    String unite; 

    public Matierequantite_v(){ }
    
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
    public int getIdmatiere(){
        return this.idmatiere;
    }
    public void setIdmatiere(int idmatiere){
        this.idmatiere=idmatiere;
    }
    public String getNommatiere(){
        return this.nommatiere;
    }
    public void setNommatiere(String nommatiere){
        this.nommatiere=nommatiere;
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
    public double getQuantite(){
        return this.quantite;
    }
    public void setQuantite(double quantite){
        this.quantite=quantite;
    }
    public String getUnite(){
        return this.unite;
    }
    public void setUnite(String unite){
        this.unite=unite;
    }

}
