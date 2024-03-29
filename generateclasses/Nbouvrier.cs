namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("nbouvrier")]
public class Nbouvrier : Motherobj<Nbouvrier>  {
    [Key]
    [Column("idnbouvrier")]
    public int idnbouvrier {get; set;} 
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("nombre")]
    public double nombre {get; set;} 

    public Nbouvrier(){ }
    

}
