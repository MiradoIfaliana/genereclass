namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("style")]
public class Style : Motherobj<Style>  {
    [Key]
    [Column("idstyle")]
    public int idstyle {get; set;} 
    [Column("nomstyle")]
    public string nomstyle {get; set;} 

    public Style(){ }
    

}
