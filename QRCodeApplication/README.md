## QRCode Application

### Funzionamento
> Aprendo una nuova scheda: si genera un nuovo web socket.
All'apertura della scheda (@OnOpen) viene effettuata la richiesta di un immagine QRCode (@Path("qrcode/{token}")) nel quale viene specificato l'id della sessione stabilita dal web socket (Session webSocketSession.getId)

> OnOpen -> Carica un qrcode contentente (il "{token}" = ) GENERATE_QR@localhost:8080/QRCodeAuthentication/authenticate/webSocketId 

> L'applicazione mobile effettua una richiesta inoltrando la stringa letta dal QRCode, specificando username, password e applicationId, che sono salvate nell'applicazione mobile.

> Il codice QR letto dall'applicazione contiene al suo interno l'id della sessione della pagina del browser: una volta autenticato, si associa il cookie alla sessione e l'utente riesce ad accedere alle varie pagine mediante il cookie.

> L'applicazione mobile legge la stringa (che consiste in un'URL di richiesta / chiamata all'API di autenticazione alla quale mancano username, password e applicationId) rappresentata dal codice qr, contatena username, password e applicationId (che vengono memorizzate all'interno dell'applicazione mobile) alla stringa, effettua la chiamata all'API utilizzando la stringa completata.

> Essendo presente nella string l'id della sessione del web socket, l'API chiamata, inoltra la stringa completa al Web Socket, che estrapola la funziona associata (AUTH@...) ed effettua una nuova chiamata alle API. Il web socket riceve quindi la risposta (con il cookie di sessione in caso di avvenuta autenticazione)