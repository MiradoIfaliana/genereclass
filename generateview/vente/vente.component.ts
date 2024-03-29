import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-vente',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './vente.component.html',
  styleUrl: './vente.component.css'
})

export class VenteComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  ventes:any;
  vente:any;
  categories:any;
  styles:any;
  tailles:any;
  clients:any;

  constructor(private http: HttpClient) {
    this.setVentes();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setVentes(){
    this.http.get('http://localhost:5031/api/VenteController/readVenteDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.ventes=response.data;
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
  setClient(){
    this.http.get('http://localhost:5031/api/ClientController/readClient', {}).subscribe((response :any) => {
      this.clients=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }


  //recuperation by Id
  setVenteById(id:number){
    if(this.ventes!=null){
      for(let i=0;i<this.ventes.length;i++){
        if(this.ventes[i].idvente==id){ this.vente=this.ventes[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(venteForm: NgForm) {
    if(venteForm.valid){
      const vente=venteForm.value;
      console.log(vente);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/VenteController/createVente', vente).subscribe((response) => {
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
    console.log(this.vente);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/VenteController/updateVente', this.vente).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/VenteController/deleteVente?id='+id).subscribe((response) => {
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
      this.setClient();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setVenteById(id);
      console.log(this.vente);
      this.setCategorie();
      this.setStyle();
      this.setTaille();
      this.setClient();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setVentes();
    }
  }
//-----------------------------------------------------------


}
