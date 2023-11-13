import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Contact } from 'src/app/model/contact';
import { User } from 'src/app/model/user';
import { ProfileService } from './profile.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/core/services/auth.service';

// Definizione dei tipi per il form
interface UserFormType {
  firstName: FormControl<string | null>;
  lastName: FormControl<string | null>;
  birthDate: FormControl<string | null>;
  isLogged: FormControl<boolean | null>;
  job: FormControl<string | null>;
  email: FormControl<string | null>;
  telephoneNumber: FormControl<string | null>;
  mobileNumber: FormControl<string | null>;
}

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
  providers: [ProfileService], // Potrebbe non essere necessario qui, dipende da come è configurato il servizio
})
export class ProfileComponent implements OnInit {
  // Gestione dell'apertura degli accordion
  public datiPersonaliOpenState: boolean;
  public datiContattoOpenState: boolean;

  photoUrl: string = './assets/user-profile.png'; // Percorso dell'immagine di default

  userId: string = ''; // ID dell'utente, viene estratto dai parametri dell'URL

  public user: User = new User(); // Oggetto dell'utente
  userForm: FormGroup<UserFormType>; // Il form per l'utente

  constructor(
    private profileService: ProfileService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.userId = this.activatedRoute.snapshot.params.id; // Ottiene l'ID dall'URL

    // Inizializzazione del form con i campi e le validazioni
    this.userForm = new FormGroup<UserFormType>({
      // Definizione dei campi del form con le relative validazioni
      // I campi vengono inizializzati con i valori presenti nell'oggetto res se l'ID esiste
      firstName: new FormControl<string | null>('', Validators.required),
      lastName: new FormControl<string | null>('', Validators.required),
      birthDate: new FormControl<string | null>(''),
      isLogged: new FormControl<boolean | null>(false),
      job: new FormControl<string | null>(''),
      email: new FormControl<string | null>(''),
      telephoneNumber: new FormControl<string | null>(''),
      mobileNumber: new FormControl<string | null>(''),
    });

    if (this.userId) {
      // Se esiste un ID, viene caricato l'utente associato
      this.profileService.getUser(this.userId).subscribe({
        next: (res) => {
          // Popola il form con i dati dell'utente
          this.userForm.patchValue(res);
        },
        error: (err) => console.error(err),
      });
    }

    /* dati per accordion */
    this.datiPersonaliOpenState = true; // Impostazione iniziale degli accordion
    this.datiContattoOpenState = true;
  }

  saveUser() {
    if (this.userId) {
      // Se esiste un ID, aggiorna l'utente con i valori del form
      this.profileService
        .updateUser({ ...this.userForm.value, id: this.userId })
        .subscribe({
          next: () => {
            console.log('ok');
          },
          error: () => {
            alert('Errore: utente non modificato');
          },
        });
    } else {
      // Altrimenti crea un nuovo utente con i valori del form
      this.profileService.createUser(this.userForm.value).subscribe({
        next: (res) => {
          // Imposta la sessione con l'ID dell'utente creato e reindirizza alla pagina del profilo
          this.authService.setSession(res.name);
          this.router.navigate(['profile', res.name]);
        },
        error: () => {
          alert('Errore: utente non creato');
        },
        complete: () => {
          console.log('Completato');
        },
      });
    }
  }

  deleteUser() {
    // Elimina l'utente tramite l'ID
    this.profileService.deleteUser(this.userId).subscribe({
      next: () => {
        console.log('ok');
        // TODO: Aggiungere azioni dopo l'eliminazione
      },
      error: () => {
        alert('Errore: utente non cancellato');
      },
    });
  }
}
