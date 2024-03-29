namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("matiereprix")]
public class Matiereprix : Motherobj<Matiereprix>  {
    [Key]
    [Column("idmatiereprix")]
    public int idmatiereprix {get; set;} 
    [Column("idmatiere")]
    public int idmatiere {get; set;} 
    [Column("prix")]
    public double prix {get; set;} 
    [Column("dateprix")]
    public DateTime dateprix {get; set;} 

    public Matiereprix(){ }
    

}
