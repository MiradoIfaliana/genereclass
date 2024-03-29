import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-fabrication',
  standalone: true,
  imports: [
    CommonModule,FormsModule,HttpClientModule
  ],
  templateUrl: './fabrication.component.html',
  styleUrl: './fabrication.component.css'
})

export class FabricationComponent {
  popoActiveSave: boolean =false;
  popoActiveUpdate: boolean =false;
  popoActiveListe: boolean =false;
  fabrications:any;
  fabrication:any;
  categories:any;
  tailles:any;
  styles:any;

  constructor(private http: HttpClient) {
    this.setFabrications();
    }

//------------------------------------------------------------------------WEBSERVICE
  //READ---LISTE
  setFabrications(){
    this.http.get('http://localhost:5031/api/FabricationController/readFabricationDetailed', {}).subscribe((response :any) => {
      // Gérer la réponse ici
      this.fabrications=response.data;
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
  setTaille(){
    this.http.get('http://localhost:5031/api/TailleController/readTaille', {}).subscribe((response :any) => {
      this.tailles=response.data;
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


  //recuperation by Id
  setFabricationById(id:number){
    if(this.fabrications!=null){
      for(let i=0;i<this.fabrications.length;i++){
        if(this.fabrications[i].idfabrication==id){ this.fabrication=this.fabrications[i]; }
      }
    }
  }
  //CREATE
  submitFormCreate(fabricationForm: NgForm) {
    if(fabricationForm.valid){
      const fabrication=fabricationForm.value;
      console.log(fabrication);
      // Envoi de la requête POST
      this.http.post('http://localhost:5031/api/FabricationController/createFabrication', fabrication).subscribe((response) => {
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
    console.log(this.fabrication);
    // Envoi de la requête POST
    this.http.post('http://localhost:5031/api/FabricationController/updateFabrication', this.fabrication).subscribe((response) => {
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
    this.http.delete('http://localhost:5031/api/FabricationController/deleteFabrication?id='+id).subscribe((response) => {
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
      this.setTaille();
      this.setStyle();

    }
  }

  //afficher le form d'update
  popopUpdate(id:number){
    this.popoActiveSave = false;
    this.popoActiveListe = false;
    this.popoActiveUpdate = !this.popoActiveUpdate;
    if(this.popoActiveUpdate==true){
      this.setFabricationById(id);
      console.log(this.fabrication);
      this.setCategorie();
      this.setTaille();
      this.setStyle();

    }
  }
  
  //afficher les listes
  popopListe(){
    this.popoActiveSave = false;
    this.popoActiveUpdate = false;
    this.popoActiveListe = !this.popoActiveListe;
    if(this.popoActiveListe==true){
      this.setFabrications();
    }
  }
//-----------------------------------------------------------


}
