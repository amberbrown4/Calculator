import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Server server = null;
        try {
            server = new Server();
        } catch (IOException e) {
            System.out.println("Can't create server: " + e.getMessage());
            System.exit(-1);
        }
        Thread serverThread = new Thread(server);
        serverThread.start();
        Client client = new Client();
        Frame frame= new Frame(client);
    }


}
