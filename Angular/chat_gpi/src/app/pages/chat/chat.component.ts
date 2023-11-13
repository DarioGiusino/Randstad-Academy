import { Component, OnInit } from '@angular/core';
import { ChatService } from './chat.service';
import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
})
export class ChatComponent implements OnInit {
  users; // Lista degli utenti
  senderIdSub = this.authService.senderId; // Sottoscrizione all'ID del mittente
  senderId: string; // ID del mittente
  receiverId: string; // ID del destinatario
  messages; // Messaggi della chat

  constructor(
    private chatService: ChatService,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.loadUsers(); // Carica la lista degli utenti all'avvio

    // Sottoscrizione all'ID del mittente
    this.senderIdSub.subscribe({
      next: (res) => {
        this.senderId = res; // Imposta l'ID del mittente
      },
    });
  }

  // Carica la lista degli utenti
  loadUsers() {
    this.chatService.getUsers().subscribe({
      next: (res) => (this.users = res), // Assegna la lista degli utenti
      error: (err) => console.error(err), // Gestione errori
    });
  }

  // Carica la chat con un utente specifico
  loadChat(receiver) {
    this.receiverId = receiver; // Imposta l'ID del destinatario

    // Ottiene la conversazione tra mittente e destinatario
    this.chatService.getConversation(this.senderId, receiver).subscribe({
      next: (res) => {
        this.messages = res; // Assegna i messaggi della chat
      },
    });
  }

  // Ricerca degli utenti in base al testo inserito
  searchUser(event: string) {
    this.chatService.getUsers().subscribe({
      next: (res) => {
        // Filtra gli utenti in base al testo della ricerca
        this.users = res.filter((user) =>
          `${user?.firstName.toLowerCase()} ${user?.lastName.toLowerCase()}`.includes(
            event.toLowerCase()
          )
        );
      },
      error: (err) => console.error(err), // Gestione errori
    });
  }
}
