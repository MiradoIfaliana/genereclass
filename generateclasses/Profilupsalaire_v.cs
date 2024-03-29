namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("profilupsalaire_v")]
public class Profilupsalaire_v : Motherobj<Profilupsalaire_v>  {
    [Column("idprofilupsalaire")]
    public int idprofilupsalaire {get; set;} 
    [Column("idprofil")]
    public int idprofil {get; set;} 
    [Column("salairefois")]
    public double salairefois {get; set;} 
    [Column("dateupsalaire")]
    public DateTime dateupsalaire {get; set;} 

    public Profilupsalaire_v(){ }
    

}
