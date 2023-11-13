import { NgModule } from '@angular/core';
import { NavbarComponent } from './navbar/navbar.component';
import { SharedModule } from '../shared/shared.module';
import { LoaderComponent } from './loader/loader.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoaderInterceptor } from './interceptors/loader-interceptor';
import { AuthComponent } from './auth/auth.component';
import { CoreRoutingModule } from './core-routing.module';

@NgModule({
  declarations: [NavbarComponent, LoaderComponent, AuthComponent], // Dichiarazione dei componenti del modulo Core
  imports: [SharedModule, CoreRoutingModule], // Importazione di moduli esterni necessari
  exports: [NavbarComponent, LoaderComponent, AuthComponent], // Esportazione dei componenti per essere utilizzati in altri moduli
  providers: [
    {
      provide: HTTP_INTERCEPTORS, // Fornisce un'intercettazione HTTP
      useClass: LoaderInterceptor, // Utilizza l'intercettore per il caricamento
      multi: true, // Consente l'uso di più interceptor simultaneamente
    },
  ],
})
export class CoreModule {} // Modulo principale che raggruppa componenti, moduli e provider relativi al core dell'applicazione
