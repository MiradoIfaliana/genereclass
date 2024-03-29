namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("stylematiere2_v")]
public class Stylematiere2_v : Motherobj<Stylematiere2_v>  {
    [Column("idmatierestyle")]
    public int idmatierestyle {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("nomstyle")]
    public string nomstyle {get; set;} 
    [Column("idmatiere")]
    public int idmatiere {get; set;} 
    [Column("nommatiere")]
    public string nommatiere {get; set;} 
    [Column("idunite")]
    public int idunite {get; set;} 
    [Column("unite")]
    public string unite {get; set;} 

    public Stylematiere2_v(){ }
    

}
