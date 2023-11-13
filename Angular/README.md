Struttura del Progetto:
Il progetto è un'applicazione basata su Angular che gestisce profili utente e messaggistica.

Componenti Principali:
Profile: Mostra e permette di modificare i dettagli del profilo dell'utente.
Chat: Gestisce le conversazioni tra utenti.

Servizi:
ProfileService: Responsabile per la gestione delle operazioni di creazione, aggiornamento ed eliminazione di profili utente.
ChatService: Gestisce il recupero e l'invio di messaggi tra utenti.
AuthService: Autentica e gestisce l'accesso degli utenti.

Moduli:
SharedModule: Racchiude componenti e moduli condivisi in più parti dell'applicazione.
ProfileModule: Si occupa di gestire il profilo utente.
ChatModule: Responsabile per la gestione della messaggistica tra utenti.

Routing:
AppRoutingModule: Definisce i percorsi principali dell'applicazione e i caricamenti differiti dei moduli.

Componenti Aggiuntivi:
UsersSearchComponent: Campo di ricerca per utenti.
UsersListComponent: Lista di utenti con azioni interattive.
ChatInputComponent: Componente per l'invio dei messaggi in una chat.
ChatWindowComponent: Mostra i messaggi della chat e consente l'invio.

Stile:
Viene utilizzato Sass per la gestione del design e dello stile dei componenti.

Il progetto sfrutta un'implementazione significativa di una direttiva personalizzata chiamata statusIndicator. Questa direttiva viene utilizzata per visualizzare lo stato di connessione di un utente (online/offline), assegnando colori e testi dinamici in base a un booleano passato.
