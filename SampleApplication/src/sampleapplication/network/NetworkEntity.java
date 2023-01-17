package sampleapplication.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class NetworkEntity {

    private final DatagramSocket socket;

    public NetworkEntity(DatagramSocket socket) {
        this.socket = socket;
    }

    public NetworkEntity(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    public void receive(DatagramPacket packet) throws IOException {
        socket.receive(packet);
    }

    public void receive(byte buf[], int length, InetAddress address, int port) throws IOException {
        receive(new DatagramPacket(buf, length, address, port));
    }

    public void send(DatagramPacket packet) throws IOException {
        socket.send(packet);
    }

    public void send(byte buf[], int length, InetAddress address, int port) throws IOException {
        send(new DatagramPacket(buf, length, address, port));
    }

    public void sendObject(Object object, InetAddress address, int port) throws IOException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(object);
        byte[] bytes = bao.toByteArray();

        send(bytes, bytes.length, address, port);
    }

    public Object receiveObject(DatagramPacket packet) throws IOException, ClassNotFoundException {
        socket.receive(packet);

        ByteArrayInputStream bai = new ByteArrayInputStream(packet.getData());
        ObjectInputStream ooi = new ObjectInputStream(bai);
        return ooi.readObject();
    }
}
