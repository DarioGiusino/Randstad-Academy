import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-users-search',
  templateUrl: './users-search.component.html',
  styleUrls: ['./users-search.component.scss'],
})
export class UsersSearchComponent {
  // EventEmitter per avviare la ricerca utente
  @Output() startUserSearch = new EventEmitter<string>();

  // Metodo chiamato alla fine dell'immissione nell'input
  searchUser(event: string) {
    // Emette l'evento per avviare la ricerca, trasmettendo il valore inserito
    this.startUserSearch.emit(event);
  }
}
