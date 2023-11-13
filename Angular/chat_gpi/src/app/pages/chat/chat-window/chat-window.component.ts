import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-chat-window',
  templateUrl: './chat-window.component.html',
  styleUrls: ['./chat-window.component.scss'],
})
export class ChatWindowComponent {
  @Input() senderId; // Identificatore del mittente
  @Input() messages; // Lista di messaggi
  @Input() receiver; // Identificatore del destinatario
}
