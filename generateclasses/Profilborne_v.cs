namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("profilborne_v")]
public class Profilborne_v : Motherobj<Profilborne_v>  {
    [Column("idprofilborne")]
    public int idprofilborne {get; set;} 
    [Column("idprofil")]
    public int idprofil {get; set;} 
    [Column("agemin")]
    public int agemin {get; set;} 
    [Column("agemax")]
    public int agemax {get; set;} 
    [Column("dateborne")]
    public DateTime dateborne {get; set;} 

    public Profilborne_v(){ }
    

}
