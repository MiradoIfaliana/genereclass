package controller;

import org.springframework.http.ResponseEntity ;
import org.springframework.web.bind.annotation.* ;

@RestController
@RequestMapping("/api/CategorieController")
public class CategorieController   { 

    @PostMapping("/CreateCategorie")
    public ResponseEntity<String> createCategorie(@RequestBody Categorie categorie) { 
        String resultat ;
        return new ResponseEntity<>(resultat) ;
    }
    
    @GetMapping("/ReadCategorie")
    public ResponseEntity<Categorie[]> readCategorie() { 
        Categorie[] resultats ;
        return new ResponseEntity<>(resultats) ;
    }
    
    @PutMapping("{id}")
    public ResponseEntity<String> updateCategorie(@PathVariable Long id, @RequestBody Categorie categorie) {
        String resultat ;
        return new ResponseEntity<>(resultat) ;
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategorie(@PathVariable Long id) { 
        String resultat ;
        return new ResponseEntity<>(resultat) ;
    }
    
}
