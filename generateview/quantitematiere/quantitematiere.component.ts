import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-quantitematiere',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './quantitematiere.component.html',
  styleUrl: './quantitematiere.component.css'
})

export class QuantitematiereComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  quantitematieres:any;
  quantitematiere:any;
  matierestyles:any;
  tailles:any;
  categories:any;

  constructor(private http: HttpClient) {
    this.setQuantitematieres();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setQuantitematieres(){
    this.http.get('http://localhost:5031/api/QuantitematiereController/readQuantitematiereDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.quantitematieres=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
  setMatierestyle(){
    this.http.get('http://localhost:5031/api/MatierestyleController/readMatierestyle', {}).subscribe((response :any) => {
      this.matierestyles=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  setTaille(){
    this.http.get('http://localhost:5031/api/TailleController/readTaille', {}).subscribe((response :any) => {
      this.tailles=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  setCategorie(){
    this.http.get('http://localhost:5031/api/CategorieController/readCategorie', {}).subscribe((response :any) => {
      this.categories=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }


  //recuperation by Id
  setQuantitematiereById(id:number){
    if(this.quantitematieres!=null){
      for(let i=0;i<this.quantitematieres.length;i++){
        if(this.quantitematieres[i].idquantitematiere==id){ this.quantitematiere=this.quantitematieres[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(quantitematiereForm: NgForm) {
    if(quantitematiereForm.valid){
      const quantitematiere=quantitematiereForm.value;
      console.log(quantitematiere);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/QuantitematiereController/createQuantitematiere', quantitematiere).subscribe((response) => {
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
    console.log(this.quantitematiere);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/QuantitematiereController/updateQuantitematiere', this.quantitematiere).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/QuantitematiereController/deleteQuantitematiere?id='+id).subscribe((response) => {
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
      this.setMatierestyle();
      this.setTaille();
      this.setCategorie();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setQuantitematiereById(id);
      console.log(this.quantitematiere);
      this.setMatierestyle();
      this.setTaille();
      this.setCategorie();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setQuantitematieres();
    }
  }
//-----------------------------------------------------------


}
