package object;

public class V_articleminunit{

    int idunitarticle; 
    int idarticle; 
    double quantiteunitaire; 
    String unitname; 

    public V_articleminunit(){}

    public int getIdunitarticle(){
        return this.idunitarticle;
    }
    public void setIdunitarticle(int idunitarticle){
        this.idunitarticle=idunitarticle;
    }
    public int getIdarticle(){
        return this.idarticle;
    }
    public void setIdarticle(int idarticle){
        this.idarticle=idarticle;
    }
    public double getQuantiteunitaire(){
        return this.quantiteunitaire;
    }
    public void setQuantiteunitaire(double quantiteunitaire){
        this.quantiteunitaire=quantiteunitaire;
    }
    public String getUnitname(){
        return this.unitname;
    }
    public void setUnitname(String unitname){
        this.unitname=unitname;
    }

}
