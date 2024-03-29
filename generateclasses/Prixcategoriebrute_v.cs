namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("prixcategoriebrute_v")]
public class Prixcategoriebrute_v : Motherobj<Prixcategoriebrute_v>  {
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("prixtotal")]
    public double prixtotal {get; set;} 

    public Prixcategoriebrute_v(){ }
    

}
