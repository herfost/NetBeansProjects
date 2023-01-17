package sampleapplication.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import sampleapplication.configuration.Config;
import sampleapplication.domain.Solid;
import sampleapplication.domain.Volume;
import sampleapplication.network.NetworkEntity;
import sampleapplication.view.IView;

public class Controller implements Serializable, ICalculator {

    private static final long serialVersionUID = 1L;

    private IView view;
    private NetworkEntity client;
    private NetworkEntity server;

    public Controller() {
    }

    public Controller(IView view, NetworkEntity client, NetworkEntity server) {
        this.view = view;
        this.client = client;
        this.server = server;
    }

    public IView getView() {
        return view;
    }

    public void setView(IView view) {
        this.view = view;
    }

    public NetworkEntity getClient() {
        return client;
    }

    public void setClient(NetworkEntity client) {
        this.client = client;
    }

    public NetworkEntity getServer() {
        return server;
    }

    public void setServer(NetworkEntity server) {
        this.server = server;
    }

    @Override
    public Volume calculateVolume(String length, String height, String width) throws UnknownHostException, IOException, ClassNotFoundException, ParseException {
        if (length.equals("") || height.equals("") || width.equals("")) {
            throw new ParseException(width, 0);
        }

        double l = Double.parseDouble(length);
        double h = Double.parseDouble(height);
        double w = Double.parseDouble(width);

        client.sendObject(new Solid(l, h, w), InetAddress.getByName(Config.SERVER_ADDRESS), Config.SERVER_PORT);

        Volume volume = new Volume();
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(volume);
        DatagramPacket packet = new DatagramPacket(bao.toByteArray(), bao.toByteArray().length);

        return (Volume) client.receiveObject(packet);
    }

    public Solid receiveSolid() throws IOException, ClassNotFoundException {
        Solid solid = new Solid();
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(solid);
        DatagramPacket packet = new DatagramPacket(bao.toByteArray(), bao.toByteArray().length);

        return (Solid) server.receiveObject(packet);
    }
}
