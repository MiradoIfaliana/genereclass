namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("personneprofilbrute_v")]
public class Personneprofilbrute_v : Motherobj<Personneprofilbrute_v>  {
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
    [Column("idprofil")]
    public int idprofil {get; set;} 
    [Column("agemin")]
    public int agemin {get; set;} 
    [Column("agemax")]
    public int agemax {get; set;} 

    public Personneprofilbrute_v(){ }
    

}
