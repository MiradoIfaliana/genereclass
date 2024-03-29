namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("matieresorti_v")]
public class Matieresorti_v : Motherobj<Matieresorti_v>  {
    [Column("idmatiere")]
    public int idmatiere {get; set;} 
    [Column("datesorti")]
    public DateTime datesorti {get; set;} 
    [Column("squantite")]
    public double squantite {get; set;} 

    public Matieresorti_v(){ }
    

}
