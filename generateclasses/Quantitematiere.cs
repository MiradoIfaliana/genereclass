namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("quantitematiere")]
public class Quantitematiere : Motherobj<Quantitematiere>  {
    [Key]
    [Column("idquantitematiere")]
    public int idquantitematiere {get; set;} 
    [Column("idmatierestyle")]
    public int idmatierestyle {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("quantite")]
    public double quantite {get; set;} 
    [Column("idcategorie")]
    public int idcategorie {get; set;} 

    public Quantitematiere(){ }
    

}
