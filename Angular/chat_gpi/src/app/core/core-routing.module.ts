import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';

// Definizione delle rotte per la navigazione
const routes: Routes = [{ path: '', component: AuthComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)], // Configura il modulo delle route con le rotte definite
  exports: [RouterModule], // Esporta il modulo della route per l'utilizzo in altri moduli
})
export class CoreRoutingModule {} // Modulo per la gestione delle route all'interno del core dell'applicazione
