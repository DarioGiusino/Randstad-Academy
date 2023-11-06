# FinalTest-Java

L'applicazione rappresenta un sistema di gestione per un negozio di giocattoli, sviluppato in linguaggio Java. Consiste in diverse classi e utility per gestire un inventario di giocattoli, le vendite effettuate e le interazioni con i clienti.

Le principali funzionalità includono:

Classi Entità: Le classi "Cliente" e "Giocattolo" rappresentano rispettivamente i clienti del negozio e i giocattoli disponibili per la vendita. Ogni entità è caratterizzata da attributi e metodi per ottenere e impostare informazioni specifiche.

Classe "Inventario": Gestisce l'elenco dei giocattoli disponibili nel negozio, fornendo funzionalità per visualizzare l'inventario e aggiungere nuovi giocattoli.

Classe "Menu": Interfaccia utente per il negozio, consentendo sia agli utenti (come i clienti) che agli amministratori di interagire con il sistema. Gli utenti possono effettuare acquisti, mentre gli amministratori possono gestire l'inventario, visualizzare le vendite e aggiungere nuovi giocattoli.

Classi di Utilità: La classe "Utilities" offre funzionalità di input da parte dell'utente, supportando vari tipi di input come Integer, Double, String, Float, Long.

Classe "Vendita" e astratta "RegistroVendite": Gestiscono la registrazione delle vendite dei giocattoli da parte dei clienti e la visualizzazione delle vendite stesse.

L'applicazione, sviluppata come parte di un percorso formativo presso Randstad Academy, dimostra l'utilizzo dei concetti fondamentali di programmazione in Java per gestire un sistema di gestione di un negozio di giocattoli. Le classi e le interfacce sono progettate per offrire una solida base concettuale e pratica nella gestione di inventari, vendite e interazioni con i clienti.


# FinalTest-Spring

L'applicazione in questione è un progetto Spring Boot che gestisce un sistema di gestione di ordini, clienti e prodotti attraverso una serie di endpoint REST.

Struttura del progetto:

Il progetto è diviso in package che comprendono classi per entità, repository, servizi e controller.
Le entità includono: Cliente, Ordine e Prodotto, ciascuna con le proprie proprietà e relazioni definite attraverso annotazioni JPA.
I repository estendono JpaRepository e permettono l'interazione con il database per le operazioni CRUD relative alle entità.
I servizi forniscono logica di business e gestiscono le operazioni sulle entità.
I controller forniscono i punti di accesso REST per le operazioni CRUD sulle entità.
Funzionalità:

Cliente: Gli endpoint consentono di recuperare tutti i clienti, trovare un cliente per ID, salvare un nuovo cliente, aggiornare o eliminare un cliente.
Ordine: Offre operazioni simili ai clienti, permettendo di gestire gli ordini in termini di recupero, creazione, aggiornamento ed eliminazione.
Prodotto: Gestisce i prodotti attraverso operazioni CRUD, consentendo di accedere, creare, aggiornare o eliminare prodotti.
Database:

È configurato un database H2 in memoria (spring.datasource.url=jdbc:h2:mem:testdb), che si crea e distrugge con l'applicazione.
Le proprietà di configurazione del datasource, del driver, dell'autenticazione e del ddl-auto per Hibernate sono specificate nel file application.properties.
L'applicazione fornisce funzionalità di base per la gestione di un sistema di ordini, consentendo agli utenti di interagire con il database attraverso API REST.
