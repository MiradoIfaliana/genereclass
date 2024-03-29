import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-categorie',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './categorie.component.html',
  styleUrl: './categorie.component.css'
})

export class CategorieComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  categories:any;
  categorie:any;

  constructor(private http: HttpClient) {
    this.setCategories();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setCategories(){
    this.http.get('http://localhost:5031/api/CategorieController/readCategorieDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.categories=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE


  //recuperation by Id
  setCategorieById(id:number){
    if(this.categories!=null){
      for(let i=0;i<this.categories.length;i++){
        if(this.categories[i].idcategorie==id){ this.categorie=this.categories[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(categorieForm: NgForm) {
    if(categorieForm.valid){
      const categorie=categorieForm.value;
      console.log(categorie);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/CategorieController/createCategorie', categorie).subscribe((response) => {
        console.log(response);
      },
        (error) => {
          console.error('Une erreur s\'est produite : ', error);
        }
      );
    }
  }

  //UPDATE
  submitFormUpdate() {
    console.log(this.categorie);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/CategorieController/updateCategorie', this.categorie).subscribe((response) => {
      console.log(response);
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //DELETE
  delete(id: number) {
    alert(id);
    this.http.delete('http://localhost:5031/api/CategorieController/deleteCategorie?id='+id).subscribe((response) => {
      console.log(response);
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
//----------------------------------------------------------------------POPOP
  //afficher le form d'insert
  popopSave(){
    this.popoActiveUpdate = false;
    this.popoActiveListe = false;
    this.popoActiveSave = !this.popoActiveSave;
    if(this.popoActiveSave==true){

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setCategorieById(id);
      console.log(this.categorie);

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setCategories();
    }
  }
//-----------------------------------------------------------


}
