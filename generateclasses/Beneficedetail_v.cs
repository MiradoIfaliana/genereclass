namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("beneficedetail_v")]
public class Beneficedetail_v : Motherobj<Beneficedetail_v>  {
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("nomcategorie")]
    public string nomcategorie {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("nomstyle")]
    public string nomstyle {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("nomtaille")]
    public string nomtaille {get; set;} 
    [Column("prixvente")]
    public double prixvente {get; set;} 
    [Column("prixrevient")]
    public double prixrevient {get; set;} 
    [Column("benefice")]
    public double benefice {get; set;} 

    public Beneficedetail_v(){ }
    

}
