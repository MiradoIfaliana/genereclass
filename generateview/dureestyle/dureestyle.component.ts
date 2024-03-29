import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-dureestyle',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './dureestyle.component.html',
  styleUrl: './dureestyle.component.css'
})

export class DureestyleComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  dureestyles:any;
  dureestyle:any;
  styles:any;

  constructor(private http: HttpClient) {
    this.setDureestyles();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setDureestyles(){
    this.http.get('http://localhost:5031/api/DureestyleController/readDureestyleDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.dureestyles=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }
  //SOUS-LISTE
  setStyle(){
    this.http.get('http://localhost:5031/api/StyleController/readStyle', {}).subscribe((response :any) => {
      this.styles=response.data;
    },
      (error) => {
        console.error('Une erreur s\'est produite : ', error);
      }
    );
  }


  //recuperation by Id
  setDureestyleById(id:number){
    if(this.dureestyles!=null){
      for(let i=0;i<this.dureestyles.length;i++){
        if(this.dureestyles[i].iddureestyle==id){ this.dureestyle=this.dureestyles[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(dureestyleForm: NgForm) {
    if(dureestyleForm.valid){
      const dureestyle=dureestyleForm.value;
      console.log(dureestyle);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/DureestyleController/createDureestyle', dureestyle).subscribe((response) => {
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
    console.log(this.dureestyle);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/DureestyleController/updateDureestyle', this.dureestyle).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/DureestyleController/deleteDureestyle?id='+id).subscribe((response) => {
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
      this.setStyle();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setDureestyleById(id);
      console.log(this.dureestyle);
      this.setStyle();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setDureestyles();
    }
  }
//-----------------------------------------------------------


}
