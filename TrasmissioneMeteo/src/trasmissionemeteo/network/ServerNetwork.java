package trasmissionemeteo.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ServerNetwork {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStream in;
    private OutputStream out;

    public ServerNetwork(ServerSocket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
        clientSocket = serverSocket.accept();
        in = clientSocket.getInputStream();
        out = clientSocket.getOutputStream();
    }

    public ServerNetwork(int port) throws IOException {
        this(new ServerSocket(port));
    }

    public void sendObject(Object object) throws IOException {
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(object);
    }

    public Object receiveObject() throws IOException, ClassNotFoundException {
        ObjectInputStream objectIn = new ObjectInputStream(in);
        return objectIn.readObject();
    }

    public void sendBytes(byte[] bytes) throws IOException {
        out.write(bytes);
    }

    public byte[] receiveBytes() throws IOException {
        byte[] buffer = new byte[1024];
        int read = in.read(buffer);

        return ByteBuffer.wrap(buffer, 0, read).array();
    }
    
    public void close() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
