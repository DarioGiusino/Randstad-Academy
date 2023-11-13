import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss'],
})
export class UsersListComponent {
  @Input() users; // Riceve l'elenco degli utenti da visualizzare
  @Output() userSelected = new EventEmitter<any>(); // Emette l'ID dell'utente selezionato

  constructor(private router: Router) {}

  // Naviga al profilo dell'utente specifico
  goToProfile(id) {
    this.router.navigate(['profile', id]);
  }

  // Emette l'evento quando un utente viene selezionato
  onUserSelected(userId) {
    this.userSelected.emit(userId);
  }
}
