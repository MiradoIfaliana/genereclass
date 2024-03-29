namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("ouvrierbesoin")]
public class Ouvrierbesoin : Motherobj<Ouvrierbesoin>  {
    [Key]
    [Column("idouvrierbesoin")]
    public int idouvrierbesoin {get; set;} 
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("idouvrier")]
    public int idouvrier {get; set;} 

    public Ouvrierbesoin(){ }
    

}
