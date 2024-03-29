import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-foreigntab',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './foreigntab.component.html',
  styleUrl: './foreigntab.component.css'
})

export class ForeigntabComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  foreigntabs:any;
  foreigntab:any;
  origintabs:any;

  constructor(private http: HttpClient) {
    this.setForeigntabs();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setForeigntabs(){
    this.http.get('http://localhost:5031/api/ForeigntabController/readForeigntabDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.foreigntabs=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
  setOrigintab(){
    this.http.get('http://localhost:5031/api/OrigintabController/readOrigintab', {}).subscribe((response :any) => {
      this.origintabs=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }


  //recuperation by Id
  setForeigntabById(id:number){
    if(this.foreigntabs!=null){
      for(let i=0;i<this.foreigntabs.length;i++){
        if(this.foreigntabs[i].id==id){ this.foreigntab=this.foreigntabs[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(foreigntabForm: NgForm) {
    if(foreigntabForm.valid){
      const foreigntab=foreigntabForm.value;
      console.log(foreigntab);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/ForeigntabController/createForeigntab', foreigntab).subscribe((response) => {
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
    console.log(this.foreigntab);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/ForeigntabController/updateForeigntab', this.foreigntab).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/ForeigntabController/deleteForeigntab?id='+id).subscribe((response) => {
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
      this.setOrigintab();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setForeigntabById(id);
      console.log(this.foreigntab);
      this.setOrigintab();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setForeigntabs();
    }
  }
//-----------------------------------------------------------


}
