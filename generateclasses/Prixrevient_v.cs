namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("prixrevient_v")]
public class Prixrevient_v : Motherobj<Prixrevient_v>  {
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("prixrevient")]
    public double prixrevient {get; set;} 

    public Prixrevient_v(){ }
    

}
