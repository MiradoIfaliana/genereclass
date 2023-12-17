package entite;

public class Matierestyle{
    int idmatierestyle; 
    int idmatiere; 
    int idstyle; 

    public Matierestyle(){ }
    
    public int getIdmatierestyle(){
        return this.idmatierestyle;
    }
    public void setIdmatierestyle(int idmatierestyle){
        this.idmatierestyle=idmatierestyle;
    }
    public int getIdmatiere(){
        return this.idmatiere;
    }
    public void setIdmatiere(int idmatiere){
        this.idmatiere=idmatiere;
    }
    public int getIdstyle(){
        return this.idstyle;
    }
    public void setIdstyle(int idstyle){
        this.idstyle=idstyle;
    }

}
