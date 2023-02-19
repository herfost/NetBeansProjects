const CONTEXT_PATH = "QRCodeApplication";
const HOST = document.location.host;
const WEB_SOCKET_PATH = "platform";

const AUTH_OPERATION = "AUTH";
const GENERATE_QRCODE_OPERATION = "GENERATE_QR";
const DIVEDER = "@";


const source = "ws://" + HOST + "/" + CONTEXT_PATH + "/" + WEB_SOCKET_PATH;
const ws = new WebSocket(source);

ws.onmessage = (event) => {
    const message = event.data;
    const operation = message.split(DIVEDER)[0];
    const URL = message.split(DIVEDER)[1];
    
    
    // URL = http://localhost:8080/QRCodeApplication/qrcode/webSocketId
    if (GENERATE_QRCODE_OPERATION === operation) {
        document.getElementById("qr-code-block").src = URL;
        document.getElementById("qr-string").innerHTML = URL;
        document.getElementById("authentication-request").innerHTML = 
                "http://localhost:8080/QRCodeApplication/authenticate/" + URL.split("/")[5] + "/admin/admin/applicationId";
    }
        
    // URL = http://localhost:8080/QRCodeApplication/authenticate/webSocketId/username/password/applicationId
    if (AUTH_OPERATION === operation) document.location = URL;
};