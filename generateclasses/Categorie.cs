namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("categorie")]
public class Categorie : Motherobj<Categorie>  {
    [Key]
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("nomcategorie")]
    public string nomcategorie {get; set;} 

    public Categorie(){ }
    

}
