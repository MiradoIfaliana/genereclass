import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-style',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './style.component.html',
  styleUrl: './style.component.css'
})

export class StyleComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  styles:any;
  style:any;

  constructor(private http: HttpClient) {
    this.setStyles();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setStyles(){
    this.http.get('http://localhost:5031/api/StyleController/readStyleDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.styles=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE


  //recuperation by Id
  setStyleById(id:number){
    if(this.styles!=null){
      for(let i=0;i<this.styles.length;i++){
        if(this.styles[i].idstyle==id){ this.style=this.styles[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(styleForm: NgForm) {
    if(styleForm.valid){
      const style=styleForm.value;
      console.log(style);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/StyleController/createStyle', style).subscribe((response) => {
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
    console.log(this.style);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/StyleController/updateStyle', this.style).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/StyleController/deleteStyle?id='+id).subscribe((response) => {
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
      this.setStyleById(id);
      console.log(this.style);

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setStyles();
    }
  }
//-----------------------------------------------------------


}
