namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("ouvrier")]
public class Ouvrier : Motherobj<Ouvrier>  {
    [Key]
    [Column("idouvrier")]
    public int idouvrier {get; set;} 
    [Column("typeouvrier")]
    public string typeouvrier {get; set;} 

    public Ouvrier(){ }
    

}
