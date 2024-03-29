namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("matiereprixnow_v")]
public class Matiereprixnow_v : Motherobj<Matiereprixnow_v>  {
    [Column("idmatiere")]
    public int idmatiere {get; set;} 
    [Column("prix")]
    public double prix {get; set;} 
    [Column("dateprix")]
    public DateTime dateprix {get; set;} 

    public Matiereprixnow_v(){ }
    

}
