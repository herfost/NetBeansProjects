package trasmissionemeteo.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ClientNetwork {
    private Socket socket;
    private InputStream in;
    private OutputStream out;

    public ClientNetwork(Socket socket) throws IOException {
        this.socket = socket;
        in = socket.getInputStream();
        out = socket.getOutputStream();
    }

    public ClientNetwork(InetAddress address, int port) throws IOException {
        this(new Socket(address, port));
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
        socket.close();
        socket.close();
    }
}