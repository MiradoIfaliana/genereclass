namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("postepersonne")]
public class Postepersonne : Motherobj<Postepersonne>  {
    [Key]
    [Column("idpostepersonne")]
    public int idpostepersonne {get; set;} 
    [Column("idpersonne")]
    public int idpersonne {get; set;} 
    [Column("idouvrier")]
    public int idouvrier {get; set;} 
    [Column("dateposte")]
    public DateTime dateposte {get; set;} 
    [Column("estactif")]
    public int estactif {get; set;} 

    public Postepersonne(){ }
    

}
