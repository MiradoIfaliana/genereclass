namespace controller;


[ApiController]
[Route["/api/CategorieController"]
public class CategorieController : ControllerBase { 


    [HttpPost("/CreateCategorie")]
    public ActionResult<String> createCategorie([FromBody] Categorie requestBody) { 
        String resultat ;
        return ok(resultat) ;
    }
    
    [HttpGet("/ReadCategorie")]
    public ActionResult<Categorie[]> readCategorie() { 
        Categorie[] resultats ;
        return ok(resultats) ;
    }
    
    [HttpPut("{id:int}")]
    public ActionResult<String> updateCategorie([FromRoute] int id, [FromBody] Categorie requestBody) {
        String resultat ;
        return ok(resultat) ;
    }
    
    [HttpDelete("{id:int}")]
    public ActionResult<String> deleteCategorie([FromRoute] int id) { 
        String resultat ;
        return ok(resultat) ;
    }
    
}
