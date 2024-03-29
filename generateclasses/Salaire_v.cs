namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("salaire_v")]
public class Salaire_v : Motherobj<Salaire_v>  {
    [Column("idsalaire")]
    public int idsalaire {get; set;} 
    [Column("idouvrier")]
    public int idouvrier {get; set;} 
    [Column("salaires")]
    public double salaires {get; set;} 
    [Column("datesalaire")]
    public DateTime datesalaire {get; set;} 

    public Salaire_v(){ }
    

}
