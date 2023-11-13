import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatComponent } from './chat.component';

const routes: Routes = [
  { path: '', component: ChatComponent }, // Definizione del percorso per il componente ChatComponent
];

@NgModule({
  imports: [RouterModule.forChild(routes)], // Impostazione dei percorsi di routing definiti sopra
  exports: [RouterModule], // Esportazione del modulo di routing
})
export class ChatRoutingModule {}
