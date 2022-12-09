package trasmissionemeteo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import trasmissionemeteo.domain.MeteoData;
import trasmissionemeteo.network.ClientNetwork;
import trasmissionemeteo.network.ServerNetwork;
import trasmissionemeteo.persistence.MeteoDataPersistence;

public class TrasmissioneMeteo {

    public static final int SERVER_PORT = 50000;
    public static final String uids[] = {"007", "008", "009", "010", "011"};
    public static final double temperatues[] = {20, 30, 30, 20, 30};
    public static final double umidities[] = {10, 20, 30, 40, 50};
    public static final String exportFilePath = "./assets/exportMeteoData.dat";

    public static void runServer() {
        MeteoDataPersistence persistence = new MeteoDataPersistence();

        try {
            ServerNetwork server = new ServerNetwork(SERVER_PORT);
            while (true) {
                MeteoData data = (MeteoData) server.receiveObject();
                persistence.create(data);
                System.out.println(persistence.read(data.getKey()));
                persistence.export(exportFilePath);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(TrasmissioneMeteo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void runClient() {

        try {
            ClientNetwork client = new ClientNetwork(InetAddress.getLocalHost(), SERVER_PORT);
            for (int i = 0; i < temperatues.length; ++i) {
                client.sendObject(new MeteoData(uids[i], temperatues[i], umidities[i]));
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(TrasmissioneMeteo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrasmissioneMeteo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void showExportedPersistence() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(exportFilePath));
        ArrayList<MeteoData> meteoDatas = (ArrayList<MeteoData>) in.readObject();
        meteoDatas.forEach((data) -> {
            System.out.println(data);
        });
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, InterruptedException {
        Thread t1 = new Thread(() -> {
            runServer();
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            runClient();
        });
        t2.start();

        t1.join();
        t2.join();

        showExportedPersistence();
    }
}
