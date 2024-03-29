import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-matiere',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './matiere.component.html',
  styleUrl: './matiere.component.css'
})

export class MatiereComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  matieres:any;
  matiere:any;
  unites:any;

  constructor(private http: HttpClient) {
    this.setMatieres();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setMatieres(){
    this.http.get('http://localhost:5031/api/MatiereController/readMatiereDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.matieres=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
  setUnite(){
    this.http.get('http://localhost:5031/api/UniteController/readUnite', {}).subscribe((response :any) => {
      this.unites=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }


  //recuperation by Id
  setMatiereById(id:number){
    if(this.matieres!=null){
      for(let i=0;i<this.matieres.length;i++){
        if(this.matieres[i].idmatiere==id){ this.matiere=this.matieres[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(matiereForm: NgForm) {
    if(matiereForm.valid){
      const matiere=matiereForm.value;
      console.log(matiere);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/MatiereController/createMatiere', matiere).subscribe((response) => {
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
    console.log(this.matiere);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/MatiereController/updateMatiere', this.matiere).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/MatiereController/deleteMatiere?id='+id).subscribe((response) => {
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
      this.setUnite();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setMatiereById(id);
      console.log(this.matiere);
      this.setUnite();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setMatieres();
    }
  }
//-----------------------------------------------------------


}
