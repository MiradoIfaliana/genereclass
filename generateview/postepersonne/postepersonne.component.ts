import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-postepersonne',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './postepersonne.component.html',
  styleUrl: './postepersonne.component.css'
})

export class PostepersonneComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  postepersonnes:any;
  postepersonne:any;
  personnes:any;
  ouvriers:any;

  constructor(private http: HttpClient) {
    this.setPostepersonnes();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setPostepersonnes(){
    this.http.get('http://localhost:5031/api/PostepersonneController/readPostepersonneDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.postepersonnes=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
  setPersonne(){
    this.http.get('http://localhost:5031/api/PersonneController/readPersonne', {}).subscribe((response :any) => {
      this.personnes=response.data;
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
  setPostepersonneById(id:number){
    if(this.postepersonnes!=null){
      for(let i=0;i<this.postepersonnes.length;i++){
        if(this.postepersonnes[i].idpostepersonne==id){ this.postepersonne=this.postepersonnes[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(postepersonneForm: NgForm) {
    if(postepersonneForm.valid){
      const postepersonne=postepersonneForm.value;
      console.log(postepersonne);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/PostepersonneController/createPostepersonne', postepersonne).subscribe((response) => {
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
    console.log(this.postepersonne);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/PostepersonneController/updatePostepersonne', this.postepersonne).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/PostepersonneController/deletePostepersonne?id='+id).subscribe((response) => {
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
      this.setPersonne();
      this.setOuvrier();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setPostepersonneById(id);
      console.log(this.postepersonne);
      this.setPersonne();
      this.setOuvrier();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setPostepersonnes();
    }
  }
//-----------------------------------------------------------


}
