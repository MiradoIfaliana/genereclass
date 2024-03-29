namespace crudnet.Controllers;

using Microsoft.AspNetCore.Mvc ;
using Microsoft.AspNetCore.Mvc ;
using System.Collections ;
using Npgsql ;
using crudnet.Models ;

[ApiController]
[Route("api/MatiereController")]
public class MatiereController : ControllerBase { 

    [HttpPost("createMatiere")]
    public Dictionary<string, object> createMatiere([FromBody] Matiere matiere) { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            matiere.create(connexion,matiere) ;
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
    
    [HttpGet("readMatiere")]
    public Dictionary<string, object> readMatiere() { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Matiere matiere = new Matiere() ;
            response["status"]=200 ;
            response["data"]=matiere.read(connexion) ;
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
    
    [HttpGet("readMatiereDetailed")]
    public Dictionary<string, object> readMatiereDetailed() { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Matiere matiere = new Matiere() ;
            string query = "select matiere.idmatiere,matiere.nommatiere,unite.idunite,unite.nomunite,unite.unite from matiere join unite on unite.idunite=matiere.idunite " ;
            response["status"]=200 ;
            response["data"]=matiere.getResultOfSelectQuery(connexion, query) ;
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
    
    [HttpGet("readMatiereById")]
    public Dictionary<string, object> readMatiereById( int id) { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Matiere matiere = new Matiere() ;
            response["status"]=200 ;
            response["data"]=matiere.readById(connexion,id) ;
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
    
    [HttpPost("updateMatiere")]
    public Dictionary<string, object> updateMatiere( int id, [FromBody] Matiere matiere) {
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            matiere.idmatiere=id ;
            matiere.update(connexion,matiere) ;
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
    
    [HttpDelete("deleteMatiere")]
    public Dictionary<string, object> deleteMatiere( int id) { 
        Connection connect= new Connection() ;
        NpgsqlConnection connexion = connect.GetConnectionPsql() ;
        Dictionary<string, object> response = new Dictionary<string, object>() ;
        try{
            Matiere matiere = new Matiere() ;
            matiere.idmatiere=id ;
            matiere.delete(connexion,matiere) ;
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
