namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("clientvente_v")]
public class Clientvente_v : Motherobj<Clientvente_v>  {
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
    [Column("nomclient")]
    public string nomclient {get; set;} 
    [Column("genre")]
    public int genre {get; set;} 
    [Column("nee")]
    public DateTime nee {get; set;} 

    public Clientvente_v(){ }
    

}
