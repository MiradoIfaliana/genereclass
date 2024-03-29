namespace entite;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("client")]
public class Client : Motherobj<Client>  {
    [Key]
    [Column("idclient")]
    public int idclient {get; set;} 
    [Column("nomclient")]
    public string nomclient {get; set;} 
    [Column("genre")]
    public int genre {get; set;} 
    [Column("nee")]
    public DateTime nee {get; set;} 

    public Client(){ }
    

}
