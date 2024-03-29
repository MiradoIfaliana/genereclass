import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-ouvrierbesointaille',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './ouvrierbesointaille.component.html',
  styleUrl: './ouvrierbesointaille.component.css'
})

export class OuvrierbesointailleComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  ouvrierbesointailles:any;
  ouvrierbesointaille:any;
  tailles:any;
  ouvrierbesoins:any;

  constructor(private http: HttpClient) {
    this.setOuvrierbesointailles();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setOuvrierbesointailles(){
    this.http.get('http://localhost:5031/api/OuvrierbesointailleController/readOuvrierbesointailleDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.ouvrierbesointailles=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
  setTaille(){
    this.http.get('http://localhost:5031/api/TailleController/readTaille', {}).subscribe((response :any) => {
      this.tailles=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  setOuvrierbesoin(){
    this.http.get('http://localhost:5031/api/OuvrierbesoinController/readOuvrierbesoin', {}).subscribe((response :any) => {
      this.ouvrierbesoins=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }


  //recuperation by Id
  setOuvrierbesointailleById(id:number){
    if(this.ouvrierbesointailles!=null){
      for(let i=0;i<this.ouvrierbesointailles.length;i++){
        if(this.ouvrierbesointailles[i].idouvrierbesointaille==id){ this.ouvrierbesointaille=this.ouvrierbesointailles[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(ouvrierbesointailleForm: NgForm) {
    if(ouvrierbesointailleForm.valid){
      const ouvrierbesointaille=ouvrierbesointailleForm.value;
      console.log(ouvrierbesointaille);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/OuvrierbesointailleController/createOuvrierbesointaille', ouvrierbesointaille).subscribe((response) => {
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
    console.log(this.ouvrierbesointaille);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/OuvrierbesointailleController/updateOuvrierbesointaille', this.ouvrierbesointaille).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/OuvrierbesointailleController/deleteOuvrierbesointaille?id='+id).subscribe((response) => {
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
      this.setTaille();
      this.setOuvrierbesoin();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setOuvrierbesointailleById(id);
      console.log(this.ouvrierbesointaille);
      this.setTaille();
      this.setOuvrierbesoin();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setOuvrierbesointailles();
    }
  }
//-----------------------------------------------------------


}
