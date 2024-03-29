import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-profil',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './profil.component.html',
  styleUrl: './profil.component.css'
})

export class ProfilComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  profils:any;
  profil:any;

  constructor(private http: HttpClient) {
    this.setProfils();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setProfils(){
    this.http.get('http://localhost:5031/api/ProfilController/readProfilDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.profils=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE


  //recuperation by Id
  setProfilById(id:number){
    if(this.profils!=null){
      for(let i=0;i<this.profils.length;i++){
        if(this.profils[i].idprofil==id){ this.profil=this.profils[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(profilForm: NgForm) {
    if(profilForm.valid){
      const profil=profilForm.value;
      console.log(profil);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/ProfilController/createProfil', profil).subscribe((response) => {
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
    console.log(this.profil);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/ProfilController/updateProfil', this.profil).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/ProfilController/deleteProfil?id='+id).subscribe((response) => {
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
      this.setProfilById(id);
      console.log(this.profil);

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setProfils();
    }
  }
//-----------------------------------------------------------


}
