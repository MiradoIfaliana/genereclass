namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("profil_v")]
public class Profil_v : Motherobj<Profil_v>  {
    [Column("idprofil")]
    public int idprofil {get; set;} 
    [Column("nomprofil")]
    public string nomprofil {get; set;} 
    [Column("agemin")]
    public int agemin {get; set;} 
    [Column("agemax")]
    public int agemax {get; set;} 
    [Column("salairefois")]
    public double salairefois {get; set;} 
    [Column("dateborne")]
    public DateTime dateborne {get; set;} 
    [Column("dateupsalaire")]
    public DateTime dateupsalaire {get; set;} 

    public Profil_v(){ }
    

}
