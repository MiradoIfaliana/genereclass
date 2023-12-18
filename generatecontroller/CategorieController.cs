namespace controller;

using Microsoft.AspNetCore.Mvc ;

[ApiController]
[Route["/api/CategorieController"]
public class CategorieController : ControllerBase { 


    [HttpPost("/CreateCategorie")]
    public ActionResult<string> createCategorie([FromBody] Categorie requestBody) { 
        string resultat ;
        return ok(resultat) ;
    }
    
    [HttpGet("/ReadCategorie")]
    public ActionResult<Categorie[]> readCategorie() { 
        Categorie[] resultats ;
        return ok(resultats) ;
    }
    
    [HttpPut("{id:int}")]
    public ActionResult<string> updateCategorie([FromRoute] int id, [FromBody] Categorie requestBody) {
        string resultat ;
        return ok(resultat) ;
    }
    
    [HttpDelete("{id:int}")]
    public ActionResult<string> deleteCategorie([FromRoute] int id) { 
        string resultat ;
        return ok(resultat) ;
    }
    
}
