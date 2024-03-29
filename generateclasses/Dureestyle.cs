namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("dureestyle")]
public class Dureestyle : Motherobj<Dureestyle>  {
    [Key]
    [Column("iddureestyle")]
    public int iddureestyle {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("duree")]
    public double duree {get; set;} 
    [Column("dateduree")]
    public DateTime dateduree {get; set;} 

    public Dureestyle(){ }
    

}
