namespace entite;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("profil")]
public class Profil : Motherobj<Profil>  {
    [Key]
    [Column("idprofil")]
    public int idprofil {get; set;} 
    [Column("nomprofil")]
    public string nomprofil {get; set;} 

    public Profil(){ }
    

}
