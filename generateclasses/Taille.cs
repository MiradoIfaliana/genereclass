namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("taille")]
public class Taille : Motherobj<Taille>  {
    [Key]
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("nomtaille")]
    public string nomtaille {get; set;} 

    public Taille(){ }
    

}
