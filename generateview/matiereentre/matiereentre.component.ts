import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-matiereentre',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './matiereentre.component.html',
  styleUrl: './matiereentre.component.css'
})

export class MatiereentreComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  matiereentres:any;
  matiereentre:any;
  matieres:any;

  constructor(private http: HttpClient) {
    this.setMatiereentres();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setMatiereentres(){
    this.http.get('http://localhost:5031/api/MatiereentreController/readMatiereentreDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.matiereentres=response.data;
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
  setMatiereentreById(id:number){
    if(this.matiereentres!=null){
      for(let i=0;i<this.matiereentres.length;i++){
        if(this.matiereentres[i].idmatiereentre==id){ this.matiereentre=this.matiereentres[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(matiereentreForm: NgForm) {
    if(matiereentreForm.valid){
      const matiereentre=matiereentreForm.value;
      console.log(matiereentre);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/MatiereentreController/createMatiereentre', matiereentre).subscribe((response) => {
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
    console.log(this.matiereentre);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/MatiereentreController/updateMatiereentre', this.matiereentre).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/MatiereentreController/deleteMatiereentre?id='+id).subscribe((response) => {
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
      this.setMatiereentreById(id);
      console.log(this.matiereentre);
      this.setMatiere();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setMatiereentres();
    }
  }
//-----------------------------------------------------------


}
