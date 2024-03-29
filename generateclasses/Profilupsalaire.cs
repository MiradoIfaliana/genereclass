namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("profilupsalaire")]
public class Profilupsalaire : Motherobj<Profilupsalaire>  {
    [Key]
    [Column("idprofilupsalaire")]
    public int idprofilupsalaire {get; set;} 
    [Column("idprofil")]
    public int idprofil {get; set;} 
    [Column("salairefois")]
    public double salairefois {get; set;} 
    [Column("dateupsalaire")]
    public DateTime dateupsalaire {get; set;} 

    public Profilupsalaire(){ }
    

}
