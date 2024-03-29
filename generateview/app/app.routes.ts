import {Routes} from '@angular/router';

import { CategorieComponent } from './categorie.component'; 
import { ClientComponent } from './client.component'; 
import { DureestyleComponent } from './dureestyle.component'; 
import { FabricationComponent } from './fabrication.component'; 
import { ForeigntabComponent } from './foreigntab.component'; 
import { MatiereComponent } from './matiere.component'; 
import { MatiereentreComponent } from './matiereentre.component'; 
import { MatiereprixComponent } from './matiereprix.component'; 
import { MatieresortiComponent } from './matieresorti.component'; 
import { MatierestyleComponent } from './matierestyle.component'; 
import { NbouvrierComponent } from './nbouvrier.component'; 
import { OrigintabComponent } from './origintab.component'; 
import { OuvrierComponent } from './ouvrier.component'; 
import { OuvrierbesoinComponent } from './ouvrierbesoin.component'; 
import { OuvrierbesointailleComponent } from './ouvrierbesointaille.component'; 
import { PersonneComponent } from './personne.component'; 
import { PostepersonneComponent } from './postepersonne.component'; 
import { PrixventeComponent } from './prixvente.component'; 
import { ProfilComponent } from './profil.component'; 
import { ProfilborneComponent } from './profilborne.component'; 
import { ProfilupsalaireComponent } from './profilupsalaire.component'; 
import { QuantitematiereComponent } from './quantitematiere.component'; 
import { SalaireComponent } from './salaire.component'; 
import { StyleComponent } from './style.component'; 
import { TailleComponent } from './taille.component'; 
import { UniteComponent } from './unite.component'; 
import { VenteComponent } from './vente.component'; 

import { AcceuilComponent } from './acceuil/acceuil.component';


export const routes: Routes = [
    { path: '', redirectTo: '/acceuil', pathMatch: 'full' }, // Redirection vers la page par défaut
    { path: 'categorie', component: CategorieComponent },
    { path: 'client', component: ClientComponent },
    { path: 'dureestyle', component: DureestyleComponent },
    { path: 'fabrication', component: FabricationComponent },
    { path: 'foreigntab', component: ForeigntabComponent },
    { path: 'matiere', component: MatiereComponent },
    { path: 'matiereentre', component: MatiereentreComponent },
    { path: 'matiereprix', component: MatiereprixComponent },
    { path: 'matieresorti', component: MatieresortiComponent },
    { path: 'matierestyle', component: MatierestyleComponent },
    { path: 'nbouvrier', component: NbouvrierComponent },
    { path: 'origintab', component: OrigintabComponent },
    { path: 'ouvrier', component: OuvrierComponent },
    { path: 'ouvrierbesoin', component: OuvrierbesoinComponent },
    { path: 'ouvrierbesointaille', component: OuvrierbesointailleComponent },
    { path: 'personne', component: PersonneComponent },
    { path: 'postepersonne', component: PostepersonneComponent },
    { path: 'prixvente', component: PrixventeComponent },
    { path: 'profil', component: ProfilComponent },
    { path: 'profilborne', component: ProfilborneComponent },
    { path: 'profilupsalaire', component: ProfilupsalaireComponent },
    { path: 'quantitematiere', component: QuantitematiereComponent },
    { path: 'salaire', component: SalaireComponent },
    { path: 'style', component: StyleComponent },
    { path: 'taille', component: TailleComponent },
    { path: 'unite', component: UniteComponent },
    { path: 'vente', component: VenteComponent },

    {path:'acceuil', component: AcceuilComponent }
];
