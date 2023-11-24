package object;

public class Magasin{

    int idmagasin; 
    String nommagasin; 
    String adressmagasin; 

    public Magasin(){}

    public int getIdmagasin(){
        return this.idmagasin;
    }
    public void setIdmagasin(int idmagasin){
        this.idmagasin=idmagasin;
    }
    public String getNommagasin(){
        return this.nommagasin;
    }
    public void setNommagasin(String nommagasin){
        this.nommagasin=nommagasin;
    }
    public String getAdressmagasin(){
        return this.adressmagasin;
    }
    public void setAdressmagasin(String adressmagasin){
        this.adressmagasin=adressmagasin;
    }

}
