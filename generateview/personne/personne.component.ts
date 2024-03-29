import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-personne',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './personne.component.html',
  styleUrl: './personne.component.css'
})

export class PersonneComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  personnes:any;
  personne:any;

  constructor(private http: HttpClient) {
    this.setPersonnes();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setPersonnes(){
    this.http.get('http://localhost:5031/api/PersonneController/readPersonneDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.personnes=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE


  //recuperation by Id
  setPersonneById(id:number){
    if(this.personnes!=null){
      for(let i=0;i<this.personnes.length;i++){
        if(this.personnes[i].idpersonne==id){ this.personne=this.personnes[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(personneForm: NgForm) {
    if(personneForm.valid){
      const personne=personneForm.value;
      console.log(personne);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/PersonneController/createPersonne', personne).subscribe((response) => {
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
    console.log(this.personne);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/PersonneController/updatePersonne', this.personne).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/PersonneController/deletePersonne?id='+id).subscribe((response) => {
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
      this.setPersonneById(id);
      console.log(this.personne);

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setPersonnes();
    }
  }
//-----------------------------------------------------------


}
