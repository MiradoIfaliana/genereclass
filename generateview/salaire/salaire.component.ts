import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-salaire',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './salaire.component.html',
  styleUrl: './salaire.component.css'
})

export class SalaireComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  salaires:any;
  salaire:any;
  ouvriers:any;

  constructor(private http: HttpClient) {
    this.setSalaires();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setSalaires(){
    this.http.get('http://localhost:5031/api/SalaireController/readSalaireDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.salaires=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
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
  setSalaireById(id:number){
    if(this.salaires!=null){
      for(let i=0;i<this.salaires.length;i++){
        if(this.salaires[i].idsalaire==id){ this.salaire=this.salaires[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(salaireForm: NgForm) {
    if(salaireForm.valid){
      const salaire=salaireForm.value;
      console.log(salaire);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/SalaireController/createSalaire', salaire).subscribe((response) => {
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
    console.log(this.salaire);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/SalaireController/updateSalaire', this.salaire).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/SalaireController/deleteSalaire?id='+id).subscribe((response) => {
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
      this.setOuvrier();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setSalaireById(id);
      console.log(this.salaire);
      this.setOuvrier();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setSalaires();
    }
  }
//-----------------------------------------------------------


}
