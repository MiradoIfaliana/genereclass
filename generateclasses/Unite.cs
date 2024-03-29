namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("unite")]
public class Unite : Motherobj<Unite>  {
    [Key]
    [Column("idunite")]
    public int idunite {get; set;} 
    [Column("nomunite")]
    public string nomunite {get; set;} 
    [Column("unite")]
    public string unite {get; set;} 

    public Unite(){ }
    

}
