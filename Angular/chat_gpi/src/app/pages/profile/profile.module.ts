import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfileComponent } from './profile.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { ProfileRoutingModule } from './profile-routing.module';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS } from '@angular/material/form-field';

@NgModule({
  declarations: [
    ProfileComponent, // Dichiarazione del componente ProfileComponent
  ],
  imports: [
    CommonModule, // Importazione del modulo CommonModule
    SharedModule, // Importazione del modulo SharedModule contenente funzionalità condivise
    ProfileRoutingModule, // Importazione del modulo per il routing del profilo
  ],
  providers: [
    // Configurazione globale per gli elementi del campo dei form all'interno del modulo
    {
      provide: MAT_FORM_FIELD_DEFAULT_OPTIONS,
      useValue: { appearance: 'outline' },
    },
  ],
})
export class ProfileModule {}
