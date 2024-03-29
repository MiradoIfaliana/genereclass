import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-profilupsalaire',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './profilupsalaire.component.html',
  styleUrl: './profilupsalaire.component.css'
})

export class ProfilupsalaireComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  profilupsalaires:any;
  profilupsalaire:any;
  profils:any;

  constructor(private http: HttpClient) {
    this.setProfilupsalaires();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setProfilupsalaires(){
    this.http.get('http://localhost:5031/api/ProfilupsalaireController/readProfilupsalaireDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.profilupsalaires=response.data;
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
  setProfilupsalaireById(id:number){
    if(this.profilupsalaires!=null){
      for(let i=0;i<this.profilupsalaires.length;i++){
        if(this.profilupsalaires[i].idprofilupsalaire==id){ this.profilupsalaire=this.profilupsalaires[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(profilupsalaireForm: NgForm) {
    if(profilupsalaireForm.valid){
      const profilupsalaire=profilupsalaireForm.value;
      console.log(profilupsalaire);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/ProfilupsalaireController/createProfilupsalaire', profilupsalaire).subscribe((response) => {
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
    console.log(this.profilupsalaire);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/ProfilupsalaireController/updateProfilupsalaire', this.profilupsalaire).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/ProfilupsalaireController/deleteProfilupsalaire?id='+id).subscribe((response) => {
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
      this.setProfilupsalaireById(id);
      console.log(this.profilupsalaire);
      this.setProfil();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setProfilupsalaires();
    }
  }
//-----------------------------------------------------------


}
