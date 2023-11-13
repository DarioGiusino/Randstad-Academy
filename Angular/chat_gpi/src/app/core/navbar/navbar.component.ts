import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  senderIdSub = this.authService.senderId; // Sottoscrizione all'ID del mittente dal servizio di autenticazione
  senderId: string = sessionStorage.getItem('senderId'); // Ottiene l'ID del mittente dalla sessione

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    // Sottoscrizione per ricevere aggiornamenti sull'ID del mittente
    this.senderIdSub.subscribe({
      next: (res) => {
        this.senderId = res; // Aggiorna l'ID del mittente quando cambia
      },
    });
  }

  resetSession() {
    this.authService.resetSession(); // Resetta la sessione utente

    // Naviga verso la pagina di autenticazione dopo il logout (rimozione commento)
    // this.router.navigate(['auth']);
  }

  goToProfile() {
    this.router.navigate(['profile', this.senderId]); // Naviga verso il profilo dell'utente attuale
  }
}
