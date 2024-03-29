import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-ouvrier',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './ouvrier.component.html',
  styleUrl: './ouvrier.component.css'
})

export class OuvrierComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  ouvriers:any;
  ouvrier:any;

  constructor(private http: HttpClient) {
    this.setOuvriers();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setOuvriers(){
    this.http.get('http://localhost:5031/api/OuvrierController/readOuvrierDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.ouvriers=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE


  //recuperation by Id
  setOuvrierById(id:number){
    if(this.ouvriers!=null){
      for(let i=0;i<this.ouvriers.length;i++){
        if(this.ouvriers[i].idouvrier==id){ this.ouvrier=this.ouvriers[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(ouvrierForm: NgForm) {
    if(ouvrierForm.valid){
      const ouvrier=ouvrierForm.value;
      console.log(ouvrier);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/OuvrierController/createOuvrier', ouvrier).subscribe((response) => {
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
    console.log(this.ouvrier);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/OuvrierController/updateOuvrier', this.ouvrier).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/OuvrierController/deleteOuvrier?id='+id).subscribe((response) => {
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
      this.setOuvrierById(id);
      console.log(this.ouvrier);

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setOuvriers();
    }
  }
//-----------------------------------------------------------


}
