namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("fabrication")]
public class Fabrication : Motherobj<Fabrication>  {
    [Key]
    [Column("idfabrication")]
    public int idfabrication {get; set;} 
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("quantitefab")]
    public double quantitefab {get; set;} 
    [Column("datefab")]
    public DateTime datefab {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 

    public Fabrication(){ }
    

}
