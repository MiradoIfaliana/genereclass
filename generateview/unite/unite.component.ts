import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-unite',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './unite.component.html',
  styleUrl: './unite.component.css'
})

export class UniteComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  unites:any;
  unite:any;

  constructor(private http: HttpClient) {
    this.setUnites();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setUnites(){
    this.http.get('http://localhost:5031/api/UniteController/readUniteDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.unites=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE


  //recuperation by Id
  setUniteById(id:number){
    if(this.unites!=null){
      for(let i=0;i<this.unites.length;i++){
        if(this.unites[i].idunite==id){ this.unite=this.unites[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(uniteForm: NgForm) {
    if(uniteForm.valid){
      const unite=uniteForm.value;
      console.log(unite);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/UniteController/createUnite', unite).subscribe((response) => {
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
    console.log(this.unite);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/UniteController/updateUnite', this.unite).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/UniteController/deleteUnite?id='+id).subscribe((response) => {
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
      this.setUniteById(id);
      console.log(this.unite);

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setUnites();
    }
  }
//-----------------------------------------------------------


}
