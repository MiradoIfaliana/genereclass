import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-client',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})

export class ClientComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  clients:any;
  client:any;

  constructor(private http: HttpClient) {
    this.setClients();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setClients(){
    this.http.get('http://localhost:5031/api/ClientController/readClientDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.clients=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE


  //recuperation by Id
  setClientById(id:number){
    if(this.clients!=null){
      for(let i=0;i<this.clients.length;i++){
        if(this.clients[i].idclient==id){ this.client=this.clients[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(clientForm: NgForm) {
    if(clientForm.valid){
      const client=clientForm.value;
      console.log(client);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/ClientController/createClient', client).subscribe((response) => {
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
    console.log(this.client);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/ClientController/updateClient', this.client).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/ClientController/deleteClient?id='+id).subscribe((response) => {
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
      this.setClientById(id);
      console.log(this.client);

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setClients();
    }
  }
//-----------------------------------------------------------


}
