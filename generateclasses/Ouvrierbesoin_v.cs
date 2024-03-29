namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("ouvrierbesoin_v")]
public class Ouvrierbesoin_v : Motherobj<Ouvrierbesoin_v>  {
    [Column("idouvrierbesoin")]
    public int idouvrierbesoin {get; set;} 
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("nomcategorie")]
    public string nomcategorie {get; set;} 
    [Column("idouvrier")]
    public int idouvrier {get; set;} 
    [Column("typeouvrier")]
    public string typeouvrier {get; set;} 

    public Ouvrierbesoin_v(){ }
    

}
