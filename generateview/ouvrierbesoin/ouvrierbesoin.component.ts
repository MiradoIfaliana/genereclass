import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-ouvrierbesoin',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './ouvrierbesoin.component.html',
  styleUrl: './ouvrierbesoin.component.css'
})

export class OuvrierbesoinComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  ouvrierbesoins:any;
  ouvrierbesoin:any;
  categories:any;
  ouvriers:any;

  constructor(private http: HttpClient) {
    this.setOuvrierbesoins();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setOuvrierbesoins(){
    this.http.get('http://localhost:5031/api/OuvrierbesoinController/readOuvrierbesoinDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.ouvrierbesoins=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
  setCategorie(){
    this.http.get('http://localhost:5031/api/CategorieController/readCategorie', {}).subscribe((response :any) => {
      this.categories=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  setOuvrier(){
    this.http.get('http://localhost:5031/api/OuvrierController/readOuvrier', {}).subscribe((response :any) => {
      this.ouvriers=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }


  //recuperation by Id
  setOuvrierbesoinById(id:number){
    if(this.ouvrierbesoins!=null){
      for(let i=0;i<this.ouvrierbesoins.length;i++){
        if(this.ouvrierbesoins[i].idouvrierbesoin==id){ this.ouvrierbesoin=this.ouvrierbesoins[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(ouvrierbesoinForm: NgForm) {
    if(ouvrierbesoinForm.valid){
      const ouvrierbesoin=ouvrierbesoinForm.value;
      console.log(ouvrierbesoin);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/OuvrierbesoinController/createOuvrierbesoin', ouvrierbesoin).subscribe((response) => {
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
    console.log(this.ouvrierbesoin);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/OuvrierbesoinController/updateOuvrierbesoin', this.ouvrierbesoin).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/OuvrierbesoinController/deleteOuvrierbesoin?id='+id).subscribe((response) => {
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
      this.setCategorie();
      this.setOuvrier();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setOuvrierbesoinById(id);
      console.log(this.ouvrierbesoin);
      this.setCategorie();
      this.setOuvrier();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setOuvrierbesoins();
    }
  }
//-----------------------------------------------------------


}
