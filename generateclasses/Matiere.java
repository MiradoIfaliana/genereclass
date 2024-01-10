package entite;

public class Matiere{
    int idmatiere; 
    String nommatiere; 
    int idunite; 

    public Matiere(){ }
    
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
    public int getIdunite(){
        return this.idunite;
    }
    public void setIdunite(int idunite){
        this.idunite=idunite;
    }

}
