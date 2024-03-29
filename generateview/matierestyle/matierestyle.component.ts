import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-matierestyle',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './matierestyle.component.html',
  styleUrl: './matierestyle.component.css'
})

export class MatierestyleComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  matierestyles:any;
  matierestyle:any;
  matieres:any;
  styles:any;

  constructor(private http: HttpClient) {
    this.setMatierestyles();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setMatierestyles(){
    this.http.get('http://localhost:5031/api/MatierestyleController/readMatierestyleDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.matierestyles=response.data;
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
  setStyle(){
    this.http.get('http://localhost:5031/api/StyleController/readStyle', {}).subscribe((response :any) => {
      this.styles=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }


  //recuperation by Id
  setMatierestyleById(id:number){
    if(this.matierestyles!=null){
      for(let i=0;i<this.matierestyles.length;i++){
        if(this.matierestyles[i].idmatierestyle==id){ this.matierestyle=this.matierestyles[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(matierestyleForm: NgForm) {
    if(matierestyleForm.valid){
      const matierestyle=matierestyleForm.value;
      console.log(matierestyle);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/MatierestyleController/createMatierestyle', matierestyle).subscribe((response) => {
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
    console.log(this.matierestyle);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/MatierestyleController/updateMatierestyle', this.matierestyle).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/MatierestyleController/deleteMatierestyle?id='+id).subscribe((response) => {
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
      this.setStyle();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setMatierestyleById(id);
      console.log(this.matierestyle);
      this.setMatiere();
      this.setStyle();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setMatierestyles();
    }
  }
//-----------------------------------------------------------


}
