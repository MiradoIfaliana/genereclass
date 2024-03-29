namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("benefice_v")]
public class Benefice_v : Motherobj<Benefice_v>  {
    [Column("idcategorie")]
    public int idcategorie {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("idtaille")]
    public int idtaille {get; set;} 
    [Column("prixvente")]
    public double prixvente {get; set;} 
    [Column("prixrevient")]
    public double prixrevient {get; set;} 
    [Column("benefice")]
    public double benefice {get; set;} 

    public Benefice_v(){ }
    

}
