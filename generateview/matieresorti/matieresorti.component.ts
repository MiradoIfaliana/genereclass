import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-matieresorti',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './matieresorti.component.html',
  styleUrl: './matieresorti.component.css'
})

export class MatieresortiComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  matieresortis:any;
  matieresorti:any;
  matieres:any;

  constructor(private http: HttpClient) {
    this.setMatieresortis();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setMatieresortis(){
    this.http.get('http://localhost:5031/api/MatieresortiController/readMatieresortiDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.matieresortis=response.data;
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
  setMatieresortiById(id:number){
    if(this.matieresortis!=null){
      for(let i=0;i<this.matieresortis.length;i++){
        if(this.matieresortis[i].idmatieresorti==id){ this.matieresorti=this.matieresortis[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(matieresortiForm: NgForm) {
    if(matieresortiForm.valid){
      const matieresorti=matieresortiForm.value;
      console.log(matieresorti);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/MatieresortiController/createMatieresorti', matieresorti).subscribe((response) => {
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
    console.log(this.matieresorti);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/MatieresortiController/updateMatieresorti', this.matieresorti).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/MatieresortiController/deleteMatieresorti?id='+id).subscribe((response) => {
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
      this.setMatieresortiById(id);
      console.log(this.matieresorti);
      this.setMatiere();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setMatieresortis();
    }
  }
//-----------------------------------------------------------


}
