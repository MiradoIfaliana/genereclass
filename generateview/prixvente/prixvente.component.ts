import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-prixvente',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './prixvente.component.html',
  styleUrl: './prixvente.component.css'
})

export class PrixventeComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  prixventes:any;
  prixvente:any;
  categories:any;
  styles:any;
  tailles:any;

  constructor(private http: HttpClient) {
    this.setPrixventes();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setPrixventes(){
    this.http.get('http://localhost:5031/api/PrixventeController/readPrixventeDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.prixventes=response.data;
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
  setStyle(){
    this.http.get('http://localhost:5031/api/StyleController/readStyle', {}).subscribe((response :any) => {
      this.styles=response.data;
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
  setPrixventeById(id:number){
    if(this.prixventes!=null){
      for(let i=0;i<this.prixventes.length;i++){
        if(this.prixventes[i].idprixvente==id){ this.prixvente=this.prixventes[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(prixventeForm: NgForm) {
    if(prixventeForm.valid){
      const prixvente=prixventeForm.value;
      console.log(prixvente);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/PrixventeController/createPrixvente', prixvente).subscribe((response) => {
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
    console.log(this.prixvente);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/PrixventeController/updatePrixvente', this.prixvente).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/PrixventeController/deletePrixvente?id='+id).subscribe((response) => {
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
      this.setStyle();
      this.setTaille();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setPrixventeById(id);
      console.log(this.prixvente);
      this.setCategorie();
      this.setStyle();
      this.setTaille();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setPrixventes();
    }
  }
//-----------------------------------------------------------


}
