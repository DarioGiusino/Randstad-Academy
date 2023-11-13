import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { CoreModule } from './core/core.module';

@NgModule({
  declarations: [
    AppComponent, // Dichiarazione del componente principale dell'applicazione
  ],
  imports: [
    BrowserModule, // Modulo fondamentale per l'esecuzione di un'applicazione web in un browser
    HttpClientModule, // Modulo per effettuare richieste HTTP
    AppRoutingModule, // Modulo che gestisce le route dell'applicazione
    BrowserAnimationsModule, // Modulo per abilitare le animazioni in Angular
    CoreModule, // Modulo principale dell'applicazione che raggruppa i moduli core e le funzionalità condivise
  ],
  providers: [], // Eventuali servizi forniti a livello globale nell'applicazione
  bootstrap: [AppComponent], // Il componente radice da cui inizia l'applicazione
})
export class AppModule {}
