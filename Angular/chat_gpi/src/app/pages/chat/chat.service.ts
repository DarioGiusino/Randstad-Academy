import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { ApiService } from 'src/app/core/services/api.service';

@Injectable()
export class ChatService {
  constructor(private api: ApiService) {}

  // Ottiene la lista degli utenti trasformando i dati restituiti in un formato leggibile
  getUsers() {
    return this.api.getUsers().pipe(
      map((user) => {
        const ids = Object.keys(user);
        const res = ids.map((id) => {
          return {
            ...user[id],
            id: id,
          };
        });
        return res;
      })
    );
  }

  // Cancella un utente tramite il suo ID
  deleteUser(id) {
    return this.api.deleteUser(id);
  }

  // Ottiene tutti i messaggi disponibili
  getMessages() {
    return this.api.getMessages();
  }

  // Invia un messaggio, passando i parametri al servizio API
  sendMessage(params) {
    return this.api.sendMessage(params);
  }

  // Ottiene la conversazione tra due utenti, confrontando gli ID del mittente e del destinatario
  getConversation(senderId, receiverId) {
    return this.api.getMessages().pipe(
      map((messages) => {
        const msgs = Object.values(messages);

        return msgs.filter(
          (message) =>
            (message.sender === senderId && message.receiver === receiverId) ||
            (message.sender === receiverId && message.receiver === senderId)
        );
      })
    );
  }
}
