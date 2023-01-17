package sampleapplication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sampleapplication.configuration.Config;
import sampleapplication.controller.Controller;
import sampleapplication.domain.Solid;
import sampleapplication.domain.Volume;
import sampleapplication.network.NetworkEntity;
import sampleapplication.view.GUIView;
import sampleapplication.view.IView;

public final class SampleApplication {

    public static IView view;
    public static Controller controller;
    public static NetworkEntity client;
    public static NetworkEntity server;

    public static final void init() throws SocketException {
        client = new NetworkEntity(Config.CLIENT_PORT);
        server = new NetworkEntity(Config.SERVER_PORT);
        controller = new Controller(view, client, server);
        view = new GUIView();
        view.setController(controller);
    }

    public static void main(String[] args) throws SocketException {
        init();

        // SERVER
        new Thread(() -> {
            while (true) {
                try {
                    Solid solid = controller.receiveSolid();
                    Volume volume = new Volume(solid.getLength() * solid.getHight() * solid.getWidth());
                    controller.getServer().sendObject(volume, InetAddress.getByName(Config.CLIENT_ADDRESS), Config.CLIENT_PORT);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(SampleApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
}
