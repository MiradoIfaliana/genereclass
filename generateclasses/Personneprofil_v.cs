namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("personneprofil_v")]
public class Personneprofil_v : Motherobj<Personneprofil_v>  {
    [Column("idpostepersonne")]
    public int idpostepersonne {get; set;} 
    [Column("idpersonne")]
    public int idpersonne {get; set;} 
    [Column("nompersonne")]
    public string nompersonne {get; set;} 
    [Column("sexe")]
    public int sexe {get; set;} 
    [Column("idouvrier")]
    public int idouvrier {get; set;} 
    [Column("typeouvrier")]
    public string typeouvrier {get; set;} 
    [Column("dateposte")]
    public DateTime dateposte {get; set;} 
    [Column("idprofil")]
    public int idprofil {get; set;} 
    [Column("nomprofil")]
    public string nomprofil {get; set;} 
    [Column("idsalaire")]
    public int idsalaire {get; set;} 
    [Column("salaires")]
    public double salaires {get; set;} 

    public Personneprofil_v(){ }
    

}
