import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-matiereprix',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './matiereprix.component.html',
  styleUrl: './matiereprix.component.css'
})

export class MatiereprixComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  matiereprixs:any;
  matiereprix:any;
  matieres:any;

  constructor(private http: HttpClient) {
    this.setMatiereprixs();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setMatiereprixs(){
    this.http.get('http://localhost:5031/api/MatiereprixController/readMatiereprixDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.matiereprixs=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
  setMatiere(){
    this.http.get('http://localhost:5031/api/MatiereController/readMatiere', {}).subscribe((response :any) => {
      this.matieres=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }


  //recuperation by Id
  setMatiereprixById(id:number){
    if(this.matiereprixs!=null){
      for(let i=0;i<this.matiereprixs.length;i++){
        if(this.matiereprixs[i].idmatiereprix==id){ this.matiereprix=this.matiereprixs[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(matiereprixForm: NgForm) {
    if(matiereprixForm.valid){
      const matiereprix=matiereprixForm.value;
      console.log(matiereprix);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/MatiereprixController/createMatiereprix', matiereprix).subscribe((response) => {
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
    console.log(this.matiereprix);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/MatiereprixController/updateMatiereprix', this.matiereprix).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/MatiereprixController/deleteMatiereprix?id='+id).subscribe((response) => {
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
      this.setMatiere();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setMatiereprixById(id);
      console.log(this.matiereprix);
      this.setMatiere();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setMatiereprixs();
    }
  }
//-----------------------------------------------------------


}
