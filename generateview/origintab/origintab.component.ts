import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-origintab',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './origintab.component.html',
  styleUrl: './origintab.component.css'
})

export class OrigintabComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  origintabs:any;
  origintab:any;

  constructor(private http: HttpClient) {
    this.setOrigintabs();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setOrigintabs(){
    this.http.get('http://localhost:5031/api/OrigintabController/readOrigintabDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.origintabs=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE


  //recuperation by Id
  setOrigintabById(id:number){
    if(this.origintabs!=null){
      for(let i=0;i<this.origintabs.length;i++){
        if(this.origintabs[i].id==id){ this.origintab=this.origintabs[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(origintabForm: NgForm) {
    if(origintabForm.valid){
      const origintab=origintabForm.value;
      console.log(origintab);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/OrigintabController/createOrigintab', origintab).subscribe((response) => {
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
    console.log(this.origintab);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/OrigintabController/updateOrigintab', this.origintab).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/OrigintabController/deleteOrigintab?id='+id).subscribe((response) => {
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
      this.setOrigintabById(id);
      console.log(this.origintab);

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setOrigintabs();
    }
  }
//-----------------------------------------------------------


}
