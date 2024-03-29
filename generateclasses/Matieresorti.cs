namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("matieresorti")]
public class Matieresorti : Motherobj<Matieresorti>  {
    [Key]
    [Column("idmatieresorti")]
    public int idmatieresorti {get; set;} 
    [Column("idmatiere")]
    public int idmatiere {get; set;} 
    [Column("squantite")]
    public double squantite {get; set;} 
    [Column("datesorti")]
    public DateTime datesorti {get; set;} 

    public Matieresorti(){ }
    

}
