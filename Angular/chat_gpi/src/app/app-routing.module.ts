import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Definizione delle rotte per la navigazione all'interno dell'applicazione
const routes: Routes = [
  // Reindirizza l'URL vuoto alla pagina di autenticazione
  { path: '', redirectTo: 'auth', pathMatch: 'full' },

  // Carica i moduli per i percorsi specificati
  {
    path: 'auth',
    loadChildren: () => import('./core/core.module').then((m) => m.CoreModule),
  },
  {
    path: 'profile',
    loadChildren: () =>
      import('./pages/profile/profile.module').then((m) => m.ProfileModule),
  },
  {
    path: 'chat',
    loadChildren: () =>
      import('./pages/chat/chat.module').then((m) => m.ChatModule),
  },

  // Se l'URL non corrisponde a nessun percorso definito, reindirizza a 'auth'
  { path: '**', redirectTo: 'auth' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // Configura il modulo delle route con le rotte definite
  exports: [RouterModule], // Esporta il modulo della route per l'utilizzo in altri moduli
})
export class AppRoutingModule {} // Modulo principale per la gestione delle route all'interno dell'applicazione
