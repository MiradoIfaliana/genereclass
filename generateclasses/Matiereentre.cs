namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("matiereentre")]
public class Matiereentre : Motherobj<Matiereentre>  {
    [Key]
    [Column("idmatiereentre")]
    public int idmatiereentre {get; set;} 
    [Column("idmatiere")]
    public int idmatiere {get; set;} 
    [Column("equantite")]
    public double equantite {get; set;} 
    [Column("dateentre")]
    public DateTime dateentre {get; set;} 

    public Matiereentre(){ }
    

}
