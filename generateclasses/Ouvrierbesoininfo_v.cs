namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("ouvrierbesoininfo_v")]
public class Ouvrierbesoininfo_v : Motherobj<Ouvrierbesoininfo_v>  {
    [Column("idouvrierbesointaille")]
    public int idouvrierbesointaille {get; set;} 
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("idouvrier")]
    public int idouvrier {get; set;} 
    [Column("nombre")]
    public int nombre {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("duree")]
    public double duree {get; set;} 
    [Column("idsalaire")]
    public int idsalaire {get; set;} 
    [Column("salaires")]
    public double salaires {get; set;} 

    public Ouvrierbesoininfo_v(){ }
    

}
