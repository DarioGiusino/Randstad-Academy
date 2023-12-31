# NegozioSportivo

Benvenuti nella Sport Store Web Application, un'applicazione per la gestione di un negozio sportivo online. Questa applicazione consente agli utenti di registrarsi, effettuare l'accesso, esplorare i prodotti disponibili nel negozio, aggiungere prodotti al carrello, effettuare acquisti e altro ancora.

## Descrizione del Progetto

L'applicazione è stata sviluppata in Java ed è basata su un'architettura client-server. Utilizza un database MySQL per la gestione dei dati degli utenti e dei prodotti disponibili nel negozio.

## Funzionalità Principali

- **Registrazione**: Gli utenti possono registrare un nuovo account inserendo informazioni come nome utente, password, email, nome e cognome.

- **Accesso**: Gli utenti registrati possono effettuare l'accesso utilizzando il loro nome utente e la password.

- **Esplorazione dei Prodotti**: Gli utenti possono esplorare l'elenco dei prodotti disponibili nel negozio e visualizzare dettagli come nome, descrizione, prezzo e disponibilità.

- **Gestione del Carrello**: Gli utenti possono aggiungere prodotti al proprio carrello, specificando la quantità desiderata. Possono anche rimuovere prodotti dal carrello.

- **Acquisto di Prodotti**: Gli utenti possono confermare l'acquisto dei prodotti presenti nel loro carrello. Il totale dell'acquisto verrà calcolato e gli utenti possono confermare o annullare l'acquisto.

- **Gestione degli Amministratori**: Gli utenti amministratori hanno accesso a funzionalità aggiuntive, come l'aggiunta e la rimozione di prodotti dal negozio.

## Requisiti

- Java JDK 21 (versione consigliata)
- MySQL Server
- JDBC Connector/J versione >=8

## Installazione

1. Clonare il repository:

`git clone https://github.com/tuonome/sport-store-app.git`

2. Aprire il progetto in Eclipse e assicurarsi di avere installato JDK 21. Se non è già installato, è possibile scaricarlo dal sito ufficiale di Oracle e configurarlo in Eclipse.

3. Aggiungere il connector JDBC MySQL (Connector/J) al progetto Eclipse:
   1. Scaricare l'ultima versione del connettore MySQL dal sito ufficiale di MySQL.
   2. In Eclipse, fare clic con il pulsante destro del mouse sul progetto e selezionare "Build Path" -> "Configure Build Path".
   3. Nella scheda "Libraries", fare clic su "Add External JARs" e selezionare il file JAR del connettore MySQL scaricato.
   4. Fare clic su "Apply and Close" per confermare.

4. Creare il database MySQL e le tabelle necessarie eseguendo le seguenti istruzioni SQL presenti su DbSetting.sql

5. Modificare le variabili statiche di connessione al database nel file NegozioDao.java per riflettere la configurazione del tuo database MySQL

6. Eseguire il progetto su Eclipse.

# Gestione Task Progetto

TASK 1: stabilire le specifiche.

TASK 2: stabilire code rules.

TASK 3: struttura DB, struttura menu, struttura entità.

TASK 4: unione delle tre logice e risoluzione di problemi di merge. (gestione esplosione github)

TASK 5: implementazione metodi comunicanti con DB: registrazione, logging

TASK 6: implementazione metodi comunicanti con DB: agginuta prodotti, rimozione prodotti da carrello e acquisto UTENTE

TASK 7: implementazione metodi comunicanti con DB: aggiunta prodotti, rimozione prodotti da negozio ADMIN

TASK 8: testing delle implementazioni riguardanti menu UTENTE.

TASK 9: testing delle implementazioni riguardanti menu ADMIN.

TASK 9: risoluzione problemi minori (typo, non interruzioni di cicli).

TASK 10: implementazione tabella acquisti in DB.

TASK 11: testing delle implementazioni riguardanti tabella acquisti.

TASK 12: implementazione documentazione

TASK 13: Implementazione ricerca per prodotto.

TASK 14: Testing ricerca per prodotto.
