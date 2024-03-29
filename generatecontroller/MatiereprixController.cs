namespace crudnet.Controllers;

using Microsoft.AspNetCore.Mvc ;
using Microsoft.AspNetCore.Mvc ;
using System.Collections ;
using Npgsql ;
using crudnet.Models ;

[ApiController]
[Route("api/MatiereprixController")]
public class MatiereprixController : ControllerBase { 

    [HttpPost("createMatiereprix")]
    public Dictionary<string, object> createMatiereprix([FromBody] Matiereprix matiereprix) { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            matiereprix.create(connexion,matiereprix) ;
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
    
    [HttpGet("readMatiereprix")]
    public Dictionary<string, object> readMatiereprix() { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Matiereprix matiereprix = new Matiereprix() ;
            response["status"]=200 ;
            response["data"]=matiereprix.read(connexion) ;
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
    
    [HttpGet("readMatiereprixDetailed")]
    public Dictionary<string, object> readMatiereprixDetailed() { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Matiereprix matiereprix = new Matiereprix() ;
            string query = "select matiereprix.idmatiereprix,matiere.idmatiere,matiere.nommatiere,matiere.idunite,matiereprix.prix,matiereprix.dateprix from matiereprix join matiere on matiere.idmatiere=matiereprix.idmatiere " ;
            response["status"]=200 ;
            response["data"]=matiereprix.getResultOfSelectQuery(connexion, query) ;
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
    
    [HttpGet("readMatiereprixById")]
    public Dictionary<string, object> readMatiereprixById( int id) { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Matiereprix matiereprix = new Matiereprix() ;
            response["status"]=200 ;
            response["data"]=matiereprix.readById(connexion,id) ;
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
    
    [HttpPost("updateMatiereprix")]
    public Dictionary<string, object> updateMatiereprix( int id, [FromBody] Matiereprix matiereprix) {
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            matiereprix.idmatiereprix=id ;
            matiereprix.update(connexion,matiereprix) ;
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
    
    [HttpDelete("deleteMatiereprix")]
    public Dictionary<string, object> deleteMatiereprix( int id) { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Matiereprix matiereprix = new Matiereprix() ;
            matiereprix.idmatiereprix=id ;
            matiereprix.delete(connexion,matiereprix) ;
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
