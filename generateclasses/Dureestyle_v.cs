namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("dureestyle_v")]
public class Dureestyle_v : Motherobj<Dureestyle_v>  {
    [Column("iddureestyle")]
    public int iddureestyle {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("duree")]
    public double duree {get; set;} 
    [Column("dateduree")]
    public DateTime dateduree {get; set;} 

    public Dureestyle_v(){ }
    

}
