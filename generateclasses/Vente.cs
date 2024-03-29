namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("vente")]
public class Vente : Motherobj<Vente>  {
    [Key]
    [Column("idvente")]
    public int idvente {get; set;} 
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("idclient")]
    public int idclient {get; set;} 
    [Column("quantite")]
    public double quantite {get; set;} 
    [Column("datevente")]
    public DateTime datevente {get; set;} 

    public Vente(){ }
    

}
