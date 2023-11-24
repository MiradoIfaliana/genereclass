namespace object;
using System; 

public class V_movementstockoutvalide{

    public int idmovementstockout { get;set; }
    public int idmovementmereout { get;set; }
    public int idmovementstockin { get;set; }
    public double quantiteout { get;set; }
    public int idmagasin { get;set; }
    public int idarticle { get;set; }
    public DateTime dateout { get;set; }
    public int etat { get;set; }
    public DateTime datevalidation { get;set; }

    public V_movementstockoutvalide(){}
    }
