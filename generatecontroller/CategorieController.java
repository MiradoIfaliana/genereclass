package controller;

import org.springframework.http.ResponseEntity ;
import org.springframework.web.bind.annotation.* ;

@RestController
@RequestMapping("/api/CategorieController")
public class CategorieController   { 

    @PostMapping("/CreateCategorie")
    public Hashtable <String,Object> createCategorie(@RequestBody Categorie categorie) { 
        Connect connect= new Connect() ;
        Connection connexion = connect.getConnection() ;
        Hashtable <String,Object> response = new Hashtable <String,Object>() ;
        try{
            categorie.create(connexion) ;
            response.put("status",200) ;
        }
        catch(Exception ex){
            response.put("status",500) ;
            response.put("message",getMessage()) ;
            e.printStackTrace() ;
        }
        finally{
            if(connexion != null){
                try{
                    connexion.close() ;
                }
                catch(Exception ex){
                    e.printStackTrace() ;
                }
            }
        }

        return response ;
    }
    
    @GetMapping("/ReadCategorie")
    public Hashtable <String,Object> readCategorie() { 
        Connect connect= new Connect() ;
        Connection connexion = connect.getConnection() ;
        Hashtable <String,Object> response = new Hashtable <String,Object>() ;
        try{
            Categorie categorie = new Categorie() ;
            response.put("status",200) ;
            response.put("data",categorie.read(connexion)) ;
        }
        catch(Exception ex){
            response.put("status",500) ;
            response.put("message",getMessage()) ;
            e.printStackTrace() ;
        }
        finally{
            if(connexion != null){
                try{
                    connexion.close() ;
                }
                catch(Exception ex){
                    e.printStackTrace() ;
                }
            }
        }

        return response ;
    }
    
    @GetMapping("/ReadCategorieById")
    public Hashtable <String,Object> readCategorieById(@RequestParam Long id) { 
        Connect connect= new Connect() ;
        Connection connexion = connect.getConnection() ;
        Hashtable <String,Object> response = new Hashtable <String,Object>() ;
        try{
            Categorie categorie = new Categorie() ;
            response.put("status",200) ;
            response.put("data",categorie.readById(connexion,id)) ;
        }
        catch(Exception ex){
            response.put("status",500) ;
            response.put("message",getMessage()) ;
            e.printStackTrace() ;
        }
        finally{
            if(connexion != null){
                try{
                    connexion.close() ;
                }
                catch(Exception ex){
                    e.printStackTrace() ;
                }
            }
        }

        return response ;
    }
    
    @PostMapping("/UpdateCategorie")
    public Hashtable <String,Object> updateCategorie(@RequestParam Long id, @RequestBody Categorie categorie) {
        Connect connect= new Connect() ;
        Connection connexion = connect.getConnection() ;
        Hashtable <String,Object> response = new Hashtable <String,Object>() ;
        try{
            categorie.setIdcategorie(id) ;
            categorie.update(connexion) ;
            response.put("status",200) ;
        }
        catch(Exception ex){
            response.put("status",500) ;
            response.put("message",getMessage()) ;
            e.printStackTrace() ;
        }
        finally{
            if(connexion != null){
                try{
                    connexion.close() ;
                }
                catch(Exception ex){
                    e.printStackTrace() ;
                }
            }
        }

        return response ;
    }
    
    @PostMapping("/DeleteCategorie")
    public Hashtable <String,Object> deleteCategorie(@RequestParam Long id) { 
        Connect connect= new Connect() ;
        Connection connexion = connect.getConnection() ;
        Hashtable <String,Object> response = new Hashtable <String,Object>() ;
        try{
            Categorie categorie = new Categorie() ;
            categorie.setIdcategorie(id) ;
            categorie.delete(connexion) ;
            response.put("status",200) ;
        }
        catch(Exception ex){
            response.put("status",500) ;
            response.put("message",getMessage()) ;
            e.printStackTrace() ;
        }
        finally{
            if(connexion != null){
                try{
                    connexion.close() ;
                }
                catch(Exception ex){
                    e.printStackTrace() ;
                }
            }
        }

        return response ;
    }
    
}
