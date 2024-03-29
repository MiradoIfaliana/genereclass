namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("matierequantite_v")]
public class Matierequantite_v : Motherobj<Matierequantite_v>  {
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("nomcategorie")]
    public string nomcategorie {get; set;} 
    [Column("idmatiere")]
    public int idmatiere {get; set;} 
    [Column("nommatiere")]
    public string nommatiere {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("nomstyle")]
    public string nomstyle {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("nomtaille")]
    public string nomtaille {get; set;} 
    [Column("quantite")]
    public double quantite {get; set;} 
    [Column("unite")]
    public string unite {get; set;} 

    public Matierequantite_v(){ }
    

}
