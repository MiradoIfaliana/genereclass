namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("prixvente_v")]
public class Prixvente_v : Motherobj<Prixvente_v>  {
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

    public Prixvente_v(){ }
    

}
