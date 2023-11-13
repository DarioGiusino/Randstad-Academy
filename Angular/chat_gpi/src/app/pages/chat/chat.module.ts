import { NgModule } from '@angular/core';

import { ChatRoutingModule } from './chat-routing.module';
import { ChatComponent } from './chat.component';
import { UsersListComponent } from './users-list/users-list.component';
import { ChatInputComponent } from './chat-input/chat-input.component';
import { ChatWindowComponent } from './chat-window/chat-window.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { ChatService } from './chat.service';
import { UsersSearchComponent } from './users-search/users-search.component';

@NgModule({
  declarations: [
    ChatComponent, // Componente principale per la gestione della chat
    UsersListComponent, // Componente per la lista degli utenti
    ChatInputComponent, // Componente per l'inserimento dei messaggi nella chat
    ChatWindowComponent, // Componente per visualizzare la finestra di chat
    UsersSearchComponent, // Componente per la ricerca degli utenti
  ],
  imports: [
    ChatRoutingModule, // Modulo per il routing della chat
    SharedModule, // Modulo condiviso che espande funzionalità e componenti
  ],
  providers: [ChatService], // Servizio per la gestione della chat
})
export class ChatModule {}
