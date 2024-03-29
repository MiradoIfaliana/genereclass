namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("ouvrierbesointaille_v")]
public class Ouvrierbesointaille_v : Motherobj<Ouvrierbesointaille_v>  {
    [Column("idouvrierbesointaille")]
    public int idouvrierbesointaille {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("idouvrierbesoin")]
    public int idouvrierbesoin {get; set;} 
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("idouvrier")]
    public int idouvrier {get; set;} 
    [Column("nombre")]
    public int nombre {get; set;} 

    public Ouvrierbesointaille_v(){ }
    

}
