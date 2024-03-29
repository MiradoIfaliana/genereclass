namespace crudnet.Controllers;

using Microsoft.AspNetCore.Mvc ;
using Microsoft.AspNetCore.Mvc ;
using System.Collections ;
using Npgsql ;
using crudnet.Models ;

[ApiController]
[Route("api/CategorieController")]
public class CategorieController : ControllerBase { 

    [HttpPost("createCategorie")]
    public Dictionary<string, object> createCategorie([FromBody] Categorie categorie) { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            categorie.create(connexion,categorie) ;
            response["status"]=200 ;
        }
        catch(Exception ex){
            response["status"]=500 ;
            response["message"]=ex.Message ;
            Console.WriteLine(ex.ToString()) ;
        }
        finally{
            if(connexion != null){
                try{
                    connexion.Close() ;
                }
                catch(Exception ex){
                    Console.WriteLine(ex.ToString()) ;
                }
            }
        }

        return response ;
    }
    
    [HttpGet("readCategorie")]
    public Dictionary<string, object> readCategorie() { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Categorie categorie = new Categorie() ;
            response["status"]=200 ;
            response["data"]=categorie.read(connexion) ;
        }
        catch(Exception ex){
            response["status"]=500 ;
            response["message"]=ex.Message ;
            Console.WriteLine(ex.ToString()) ;
        }
        finally{
            if(connexion != null){
                try{
                    connexion.Close() ;
                }
                catch(Exception ex){
                    Console.WriteLine(ex.ToString()) ;
                }
            }
        }

        return response ;
    }
    
    [HttpGet("readCategorieById")]
    public Dictionary<string, object> readCategorieById( int id) { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Categorie categorie = new Categorie() ;
            response["status"]=200 ;
            response["data"]=categorie.readById(connexion,id) ;
        }
        catch(Exception ex){
            response["status"]=500 ;
            response["message"]=ex.Message ;
            Console.WriteLine(ex.ToString()) ;
        }
        finally{
            if(connexion != null){
                try{
                    connexion.Close() ;
                }
                catch(Exception ex){
                    Console.WriteLine(ex.ToString()) ;
                }
            }
        }

        return response ;
    }
    
    [HttpPost("updateCategorie")]
    public Dictionary<string, object> updateCategorie( int id, [FromBody] Categorie categorie) {
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            categorie.idcategorie=id ;
            categorie.update(connexion,categorie) ;
            response["status"]=200 ;
        }
        catch(Exception ex){
            response["status"]=500 ;
            response["message"]=ex.Message ;
            Console.WriteLine(ex.ToString()) ;
        }
        finally{
            if(connexion != null){
                try{
                    connexion.Close() ;
                }
                catch(Exception ex){
                    Console.WriteLine(ex.ToString()) ;
                }
            }
        }

        return response ;
    }
    
    [HttpPost("deleteCategorie")]
    public Dictionary<string, object> deleteCategorie( int id) { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Categorie categorie = new Categorie() ;
            categorie.idcategorie=id ;
            categorie.delete(connexion,categorie) ;
            response["status"]=200 ;
        }
        catch(Exception ex){
            response["status"]=500 ;
            response["message"]=ex.Message ;
            Console.WriteLine(ex.ToString()) ;
        }
        finally{
            if(connexion != null){
                try{
                    connexion.Close() ;
                }
                catch(Exception ex){
                    Console.WriteLine(ex.ToString()) ;
                }
            }
        }

        return response ;
    }
    
}
