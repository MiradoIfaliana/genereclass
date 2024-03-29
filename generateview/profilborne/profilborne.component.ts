import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-profilborne',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './profilborne.component.html',
  styleUrl: './profilborne.component.css'
})

export class ProfilborneComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  profilbornes:any;
  profilborne:any;
  profils:any;

  constructor(private http: HttpClient) {
    this.setProfilbornes();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setProfilbornes(){
    this.http.get('http://localhost:5031/api/ProfilborneController/readProfilborneDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.profilbornes=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
  setProfil(){
    this.http.get('http://localhost:5031/api/ProfilController/readProfil', {}).subscribe((response :any) => {
      this.profils=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }


  //recuperation by Id
  setProfilborneById(id:number){
    if(this.profilbornes!=null){
      for(let i=0;i<this.profilbornes.length;i++){
        if(this.profilbornes[i].idprofilborne==id){ this.profilborne=this.profilbornes[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(profilborneForm: NgForm) {
    if(profilborneForm.valid){
      const profilborne=profilborneForm.value;
      console.log(profilborne);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/ProfilborneController/createProfilborne', profilborne).subscribe((response) => {
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
    console.log(this.profilborne);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/ProfilborneController/updateProfilborne', this.profilborne).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/ProfilborneController/deleteProfilborne?id='+id).subscribe((response) => {
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
      this.setProfil();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setProfilborneById(id);
      console.log(this.profilborne);
      this.setProfil();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setProfilbornes();
    }
  }
//-----------------------------------------------------------


}
