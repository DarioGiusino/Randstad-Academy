import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss'],
})
export class AuthComponent {
  users; // Variabile per memorizzare gli utenti
  selectedId; // Variabile per memorizzare l'ID dell'utente selezionato
  selectedUser; // Variabile per memorizzare l'utente selezionato

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit() {
    // Ottieni la lista degli utenti non loggati (filtrati nel service)
    this.authService.getUsers().subscribe({
      next: (res) => {
        // Assegna la risposta alla lista degli utenti
        this.users = res;
        console.log('Utenti non loggati ricevuti');
      },
      error: (err) => console.log(err), // Gestisci eventuali errori
    });
  }

  login(id: string) {
    if (!id) {
      console.error('id nullo'); // Controlla se l'ID è nullo e visualizza un errore
      return; // Interrompe l'esecuzione in caso di ID nullo
    }
    this.authService.setSession(id); // Imposta la sessione con l'ID dell'utente selezionato
    this.router.navigate(['profile', id]); // Naviga verso il profilo dell'utente
  }

  create() {
    this.authService.resetSession(); // Reimposta la sessione corrente (presumibilmente per la creazione di un nuovo utente)
    this.router.navigate(['profile']); // Naviga verso la pagina del profilo
  }
}
