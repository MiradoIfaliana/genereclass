import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-taille',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './taille.component.html',
  styleUrl: './taille.component.css'
})

export class TailleComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  tailles:any;
  taille:any;

  constructor(private http: HttpClient) {
    this.setTailles();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setTailles(){
    this.http.get('http://localhost:5031/api/TailleController/readTailleDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.tailles=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE


  //recuperation by Id
  setTailleById(id:number){
    if(this.tailles!=null){
      for(let i=0;i<this.tailles.length;i++){
        if(this.tailles[i].idtaille==id){ this.taille=this.tailles[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(tailleForm: NgForm) {
    if(tailleForm.valid){
      const taille=tailleForm.value;
      console.log(taille);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/TailleController/createTaille', taille).subscribe((response) => {
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
    console.log(this.taille);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/TailleController/updateTaille', this.taille).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/TailleController/deleteTaille?id='+id).subscribe((response) => {
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
      this.setTailleById(id);
      console.log(this.taille);

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setTailles();
    }
  }
//-----------------------------------------------------------


}
