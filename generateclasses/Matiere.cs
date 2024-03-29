namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("matiere")]
public class Matiere : Motherobj<Matiere>  {
    [Key]
    [Column("idmatiere")]
    public int idmatiere {get; set;} 
    [Column("nommatiere")]
    public string nommatiere {get; set;} 
    [Column("idunite")]
    public int idunite {get; set;} 

    public Matiere(){ }
    

}
