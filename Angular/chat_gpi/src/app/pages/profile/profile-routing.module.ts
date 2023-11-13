import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfileComponent } from './profile.component';

// Definizione delle rotte per il modulo di profilo
const routes: Routes = [
  { path: '', component: ProfileComponent }, // Rotta per visualizzare il profilo base
  { path: ':id', component: ProfileComponent }, // Rotta per visualizzare un profilo specifico tramite ID
];

@NgModule({
  imports: [RouterModule.forChild(routes)], // Configurazione del modulo delle route con le rotte definite
  exports: [RouterModule], // Esportazione del modulo della route per l'utilizzo in altri moduli
})
export class ProfileRoutingModule {}
