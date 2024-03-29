namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("personneageposte_v")]
public class Personneageposte_v : Motherobj<Personneageposte_v>  {
    [Column("idpostepersonne")]
    public int idpostepersonne {get; set;} 
    [Column("idpersonne")]
    public int idpersonne {get; set;} 
    [Column("idouvrier")]
    public int idouvrier {get; set;} 
    [Column("dateposte")]
    public DateTime dateposte {get; set;} 
    [Column("ageposte")]
    public decimal ageposte {get; set;} 

    public Personneageposte_v(){ }
    

}
