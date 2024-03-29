namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("origintab")]
public class Origintab : Motherobj<Origintab>  {
    [Key]
    [Column("id")]
    public int id {get; set;} 
    [Column("nom")]
    public string nom {get; set;} 
    [Column("nee")]
    public DateTime nee {get; set;} 

    public Origintab(){ }
    

}
