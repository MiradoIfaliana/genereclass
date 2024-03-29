import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-nbouvrier',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './nbouvrier.component.html',
  styleUrl: './nbouvrier.component.css'
})

export class NbouvrierComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  nbouvriers:any;
  nbouvrier:any;
  categories:any;
  tailles:any;

  constructor(private http: HttpClient) {
    this.setNbouvriers();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setNbouvriers(){
    this.http.get('http://localhost:5031/api/NbouvrierController/readNbouvrierDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.nbouvriers=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
  setCategorie(){
    this.http.get('http://localhost:5031/api/CategorieController/readCategorie', {}).subscribe((response :any) => {
      this.categories=response.data;
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


  //recuperation by Id
  setNbouvrierById(id:number){
    if(this.nbouvriers!=null){
      for(let i=0;i<this.nbouvriers.length;i++){
        if(this.nbouvriers[i].idnbouvrier==id){ this.nbouvrier=this.nbouvriers[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(nbouvrierForm: NgForm) {
    if(nbouvrierForm.valid){
      const nbouvrier=nbouvrierForm.value;
      console.log(nbouvrier);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/NbouvrierController/createNbouvrier', nbouvrier).subscribe((response) => {
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
    console.log(this.nbouvrier);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/NbouvrierController/updateNbouvrier', this.nbouvrier).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/NbouvrierController/deleteNbouvrier?id='+id).subscribe((response) => {
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
      this.setCategorie();
      this.setTaille();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setNbouvrierById(id);
      console.log(this.nbouvrier);
      this.setCategorie();
      this.setTaille();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setNbouvriers();
    }
  }
//-----------------------------------------------------------


}
