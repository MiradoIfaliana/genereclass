namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("prixvente")]
public class Prixvente : Motherobj<Prixvente>  {
    [Key]
    [Column("idprixvente")]
    public int idprixvente {get; set;} 
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("prixvente")]
    public double prixvente {get; set;} 
    [Column("dateprix")]
    public DateTime dateprix {get; set;} 

    public Prixvente(){ }
    

}
