# BookOnline
Questo progetto, realizzato in gruppo da due persone, rappresenta un'applicazione Java per un negozio di libri online. L'obiettivo principale è offrire agli utenti la possibilità di registrarsi, navigare nel catalogo di libri, acquistarli e condividere recensioni.

Funzionalità principali:
Gestione Utenti: Gli utenti possono registrarsi, accedere alla libreria e visualizzare il catalogo di libri.
Catalogo di Libri: I libri sono gestiti in un catalogo con informazioni come titolo, autore, genere e prezzo.
Recensioni: Gli utenti possono scrivere recensioni sui libri acquistati, valutandoli da 1 a 5 stelle.
Acquisto di Libri: Gli utenti possono acquistare libri e visualizzare i libri acquistati.
Raccomandazioni: Viene fornita una lista di libri consigliati in base ai generi preferiti dell'utente e alle recensioni positive.
Libri Popolari: Viene mostrata una lista dei libri più popolari basati sulle recensioni.

# BookShop
Questo codice rappresenta un simulatore di un negozio online di libri realizzato in Java. La classe Shop gestisce le interazioni degli utenti, consentendo loro di operare sia come "guest" che come "admin". Gli utenti "guest" possono acquistare libri, visualizzare la propria lista e accedere come "admin" tramite una password. Gli utenti "admin" hanno accesso a funzionalità avanzate come l'aggiunta, la rimozione e la modifica dei libri nel catalogo.

Caratteristiche Principali:
Ruoli Utente: Gestisce le azioni specifiche per gli utenti "guest" e "admin".
Menu Interattivi: Fornisce un'interfaccia testuale per l'utente, permettendo di scegliere azioni come l'acquisto, la visualizzazione dei libri e la gestione del catalogo.
Gestione delle Operazioni: Le funzioni di acquisto, visualizzazione e gestione dei libri sono implementate in modo modulare.

Utilizzo di Variabili Statiche:
Utilizza variabili statiche per gestire lo stato dell'applicazione, inclusa la lista dei libri, lo stato degli utenti e i menu.
Questa implementazione fornisce un'interfaccia di base per gli utenti, consentendo loro di interagire con un negozio di libri simulato. Le funzioni principali sono modulari e suddivise in metodi dedicati, facilitando l'estensione e la manutenzione del codice.

# CarManager
Il codice presenta una gestione di un database di automobili attraverso l'interfaccia utente e la manipolazione di oggetti Car. È stato sviluppato utilizzando Java, interagendo con un database MySQL.

Classi Principali:
CarManager:
Questa classe gestisce le operazioni sulle automobili, come l'aggiunta, la modifica, l'eliminazione e la visualizzazione.
È possibile anche cercare un'auto tramite la targa.
Utilizza metodi per sincronizzare i dati con il database e gestire l'interazione con esso.
Viene utilizzata la classe Utilities per l'input utente.

ConnectionUtils:
Gestisce la connessione al database e le operazioni come l'ottenimento di ResultSet, la visualizzazione dei risultati, ecc.
Utilizza la connessione JDBC per connettersi al database MySQL.

Utilities:
Classe di utilità che fornisce un metodo per l'input dell'utente.

Punti Salienti:
Operazioni CRUD: La classe CarManager consente di effettuare operazioni CRUD sul database di automobili.
Interazione con il Database: La classe ConnectionUtils gestisce la connessione al database e le operazioni su di esso, come l'esecuzione di query e il recupero dei dati.
Input Utente Sicuro: La classe Utilities fornisce un metodo per ottenere l'input dell'utente in modo sicuro, validando e convertendo i tipi.
Il codice è strutturato in modo da separare le responsabilità, facilitando la gestione e la manutenzione. Sono presenti gestione delle eccezioni e commenti per guidare la comprensione del codice.

Inoltre, il codice gestisce il formato delle date per l'inserimento e l'aggiornamento dei dati nel database.

# Esercizio Finale in Java Plain
Esercizio finale in Java plain, descritto nel ReadMe all'interno.

# Restaurant Manager
Il repository offre una soluzione di gestione delle prenotazioni per tavoli in un ristorante. La classe PrenotazioneServiceImpl fornisce metodi per prenotare un tavolo, annullare una prenotazione e visualizzare i tavoli disponibili.

Funzionalità Principali
Prenota un Tavolo: L'utente può prenotare un tavolo specificando il numero di persone, la data e l'orario desiderati.
Annulla Prenotazione: Permette di annullare una prenotazione esistente selezionando la riga corrispondente.
Visualizza Tavoli Disponibili: Fornisce un elenco dei tavoli attualmente disponibili per la prenotazione.

Struttura del Codice
Il codice è strutturato come un servizio, con l'obiettivo di gestire in modo efficace le interazioni utente attraverso un'implementazione di metodi intuitivi.

Database: Utilizzo di JDBC per l'interazione con un database MySQL.
Gestione Utente: Interazione utente tramite input da console.
Il codice utilizza pattern di programmazione ad oggetti, l'accesso a database relazionali e la gestione di eccezioni per garantire un funzionamento affidabile.

# ShopJDBC
Il repository fornisce un'applicazione di gestione di un negozio che permette agli utenti di visualizzare il catalogo, gestire il carrello degli acquisti e accedere a funzionalità amministrative tramite una "ADMIN DASHBOARD". Questa struttura adotta i concetti di DAO (Data Access Object) e utilizza classi DTO (Data Transfer Object) per separare la logica di business dall'accesso ai dati.

Classi Implementate
ProdottoDAO.java: Questa classe gestisce l'accesso ai dati dei prodotti del negozio. Offre metodi per le operazioni di base, come l'inserimento, la modifica, l'eliminazione e il recupero dei prodotti dal database.

ClienteDAO.java: Analogamente a ProdottoDAO, questa classe si occupa dell'accesso ai dati dei clienti, fornendo funzionalità simili per l'interazione con la tabella dei clienti.

OrdineDAO.java: Gestisce l'accesso ai dati degli ordini effettuati, offrendo i metodi necessari per gestire le informazioni sugli ordini nel database.

DTO Classi (es. ProdottoDTO, ClienteDTO, OrdineDTO): Queste classi contengono attributi e metodi per trasferire dati tra la logica dell'applicazione e il database. Ogni classe DTO rappresenta una tabella del database e definisce le strutture dati necessarie per il trasferimento dei dati.

Flusso dell'Applicazione
Guest:
Possono visualizzare il catalogo dei prodotti e aggiungere articoli al carrello.
Possono accedere alla "ADMIN DASHBOARD" inserendo una password specifica.

Admin:
Hanno accesso alla "ADMIN DASHBOARD" per gestire prodotti, clienti e ordini.
Utilizzo di DAO e DTO

L'utilizzo di DAO permette di separare la logica di business dall'accesso ai dati, migliorando la struttura del codice e rendendo più chiare le operazioni svolte sul database. I DTO fungono da interfacce tra le classi di accesso ai dati e la logica dell'applicazione, garantendo un trasferimento efficiente e consistente dei dati.

La struttura DAO-DTO adottata favorisce la modularità del codice, semplificando la manutenzione e l'estensione del sistema nel tempo.

# StazioneMeteo
Il codice fornito rappresenta un'applicazione semplificata di monitoraggio meteorologico che simula una stazione meteo. Utilizza il pattern Observer per notificare i vari osservatori (come operatori e veicoli) quando ci sono aggiornamenti relativi alle condizioni meteorologiche di diverse regioni.

Descrizione del Codice:
MeteoInfo: Rappresenta le informazioni meteorologiche relative a temperatura, velocità del vento, data dell'ultimo aggiornamento e la regione associata.

Operatore e Veicolo: Implementano l'interfaccia Osservatore per ricevere gli aggiornamenti meteorologici dalla stazione meteo. Gli operatori mostrano solo informazioni sulla temperatura, mentre i veicoli mostrano la data dell'ultimo aggiornamento del meteo.

StazioneMeteo: Mantiene una lista di osservatori e aggiorna tutti gli osservatori registrati quando riceve nuove informazioni meteorologiche. Ogni osservatore interessato riceve i dati e aggiorna le informazioni di interesse.

Regione: Enumerazione delle regioni supportate per l'osservazione delle condizioni meteorologiche.

Utilizzo:
La classe principale Main inizializza la stazione meteo e diversi osservatori (operatori e veicoli) per monitorare le condizioni meteo.
Aggiunge gli osservatori alla stazione meteo.
La stazione meteo riceve informazioni meteorologiche tramite il metodo aggiornaMeteo, e successivamente notifica gli osservatori registrati.
Pattern di Progettazione:
Il codice utilizza il design pattern Observer, consentendo alla stazione meteo di notificare automaticamente gli osservatori interessati quando ci sono aggiornamenti meteorologici.

Questo esempio può essere utilizzato come base per comprendere il funzionamento del pattern Observer e come implementare la comunicazione asincrona tra oggetti, utile in contesti di notifiche e aggiornamenti distribuiti.

# TestJDBC
Il codice fornito rappresenta un'applicazione Java che interagisce con un database MySQL chiamato negozio_db, effettuando operazioni di interrogazione (SELECT) e chiusura della connessione. Inoltre, contiene un esempio di utilizzo delle classi ConnectionUtils e Main per gestire la connessione al database e visualizzare i risultati delle query.

Struttura e Funzionalità:
Main: Presenta un esempio di utilizzo della classe ConnectionUtils, eseguendo una query SQL per recuperare e visualizzare il catalogo dei prodotti dal database negozio_db.

ConnectionUtils: Contiene metodi per gestire la connessione al database MySQL (negozio_db), eseguire query, ottenere e stampare i risultati ottenuti.

Descrizione Funzionale:
Il metodo Main inizializza un'istanza di ConnectionUtils passando le credenziali e il nome del database. Successivamente esegue una query SQL che recupera i dati dalla tabella "prodotto" e li stampa a console.
Il metodo ConnectionUtils gestisce la connessione al database, riceve e stampa i risultati delle query eseguite.

Utilizzo:
L'esempio mostrato illustra come stabilire una connessione a un database MySQL, eseguire query e ottenere i risultati. Sostituendo le query all'interno del metodo main della classe Main, è possibile effettuare diverse interrogazioni e visualizzare i risultati.

Note:
L'esempio si concentra principalmente sull'esecuzione di query di selezione (SELECT) e sulla visualizzazione dei risultati restituiti.

Questo esempio può essere utilizzato come guida per l'interazione con un database MySQL da un'applicazione Java, fornendo un'introduzione semplice e pratica all'accesso e all'utilizzo dei dati memorizzati in un database relazionale.
