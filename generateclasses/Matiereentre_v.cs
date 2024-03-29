namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("matiereentre_v")]
public class Matiereentre_v : Motherobj<Matiereentre_v>  {
    [Column("idmatiere")]
    public int idmatiere {get; set;} 
    [Column("dateentre")]
    public DateTime dateentre {get; set;} 
    [Column("equantite")]
    public double equantite {get; set;} 

    public Matiereentre_v(){ }
    

}
