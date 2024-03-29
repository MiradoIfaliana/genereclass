namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("ouvrierbesointaille")]
public class Ouvrierbesointaille : Motherobj<Ouvrierbesointaille>  {
    [Key]
    [Column("idouvrierbesointaille")]
    public int idouvrierbesointaille {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("idouvrierbesoin")]
    public int idouvrierbesoin {get; set;} 
    [Column("nombre")]
    public int nombre {get; set;} 

    public Ouvrierbesointaille(){ }
    

}
