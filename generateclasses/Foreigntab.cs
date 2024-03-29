namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("foreigntab")]
public class Foreigntab : Motherobj<Foreigntab>  {
    [Key]
    [Column("id")]
    public int id {get; set;} 
    [Column("idorigin")]
    public int idorigin {get; set;} 
    [Column("daty")]
    public DateTime daty {get; set;} 

    public Foreigntab(){ }
    

}
