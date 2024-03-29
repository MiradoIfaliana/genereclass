namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("salaire")]
public class Salaire : Motherobj<Salaire>  {
    [Key]
    [Column("idsalaire")]
    public int idsalaire {get; set;} 
    [Column("idouvrier")]
    public int idouvrier {get; set;} 
    [Column("salaires")]
    public double salaires {get; set;} 
    [Column("datesalaire")]
    public DateTime datesalaire {get; set;} 

    public Salaire(){ }
    

}
