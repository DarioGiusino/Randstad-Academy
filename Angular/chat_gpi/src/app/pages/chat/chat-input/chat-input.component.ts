import { Component, Input } from '@angular/core';
import { Message } from 'src/app/model/message';
import { ChatService } from '../chat.service';

@Component({
  selector: 'app-chat-input',
  templateUrl: './chat-input.component.html',
  styleUrls: ['./chat-input.component.scss'],
})
export class ChatInputComponent {
  msg; // Messaggio immesso dall'utente

  @Input() senderId; // ID del mittente
  @Input() receiver; // ID del destinatario

  message: Message = new Message(); // Oggetto per memorizzare il messaggio

  constructor(private chatService: ChatService) {}

  sendMsg() {
    if (this.msg) {
      // Verifica se è presente un messaggio da inviare

      // Crea un nuovo oggetto messaggio con le informazioni
      this.message.date = new Date();
      this.message.message = this.msg;
      this.message.receiver = this.receiver;
      this.message.sender = this.senderId;

      // Invia il messaggio utilizzando il servizio
      this.chatService.sendMessage(this.message).subscribe({
        next: () => {
          console.log('ok'); // Messaggio inviato con successo
        },
        error: (err) => {
          console.error(err); // Gestione degli errori nell'invio del messaggio
        },
      });

      this.msg = ''; // Pulisce l'input del messaggio dopo l'invio
    }
  }
}
