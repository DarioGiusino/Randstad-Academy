import { Contact } from './contact'; // Importa il modello 'Contact' dal file 'contact'

export class User {
  id: number; // Identificatore dell'utente (presumibilmente un numero intero)
  firstName: string; // Nome dell'utente
  lastName: string; // Cognome dell'utente
  birthDate: Date; // Data di nascita dell'utente
  bio: string; // Biografia o descrizione dell'utente
  photoUrl: string; // URL dell'immagine del profilo dell'utente
  isLogged: boolean; // Indica se l'utente è attualmente loggato o meno
  job: string; // Lavoro o occupazione dell'utente
  contacts: Contact[]; // Elenco dei contatti dell'utente, rappresentati come un array di oggetti 'Contact'
}
