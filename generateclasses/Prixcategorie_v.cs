namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("prixcategorie_v")]
public class Prixcategorie_v : Motherobj<Prixcategorie_v>  {
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("nomcategorie")]
    public string nomcategorie {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("nomstyle")]
    public string nomstyle {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("nomtaille")]
    public string nomtaille {get; set;} 
    [Column("prixtotal")]
    public double prixtotal {get; set;} 

    public Prixcategorie_v(){ }
    

}
