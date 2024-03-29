namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("matierestyle")]
public class Matierestyle : Motherobj<Matierestyle>  {
    [Key]
    [Column("idmatierestyle")]
    public int idmatierestyle {get; set;} 
    [Column("idmatiere")]
    public int idmatiere {get; set;} 
    [Column("idstyle")]
    public int idstyle {get; set;} 

    public Matierestyle(){ }
    

}
