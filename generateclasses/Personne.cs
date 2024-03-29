namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("personne")]
public class Personne : Motherobj<Personne>  {
    [Key]
    [Column("idpersonne")]
    public int idpersonne {get; set;} 
    [Column("nompersonne")]
    public string nompersonne {get; set;} 
    [Column("nee")]
    public DateTime nee {get; set;} 
    [Column("sexe")]
    public int sexe {get; set;} 

    public Personne(){ }
    

}
