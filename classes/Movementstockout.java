package object;

public class Movementstockout{

    int idmovementstockout; 
    int idmovementmereout; 
    int idmovementstockin; 
    double quantiteout; 

    public Movementstockout(){}

    public int getIdmovementstockout(){
        return this.idmovementstockout;
    }
    public void setIdmovementstockout(int idmovementstockout){
        this.idmovementstockout=idmovementstockout;
    }
    public int getIdmovementmereout(){
        return this.idmovementmereout;
    }
    public void setIdmovementmereout(int idmovementmereout){
        this.idmovementmereout=idmovementmereout;
    }
    public int getIdmovementstockin(){
        return this.idmovementstockin;
    }
    public void setIdmovementstockin(int idmovementstockin){
        this.idmovementstockin=idmovementstockin;
    }
    public double getQuantiteout(){
        return this.quantiteout;
    }
    public void setQuantiteout(double quantiteout){
        this.quantiteout=quantiteout;
    }

}
