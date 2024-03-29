namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("prixrevientouvrier_v")]
public class Prixrevientouvrier_v : Motherobj<Prixrevientouvrier_v>  {
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("prixrevientouvrier")]
    public double prixrevientouvrier {get; set;} 

    public Prixrevientouvrier_v(){ }
    

}
