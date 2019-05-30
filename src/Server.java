import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
    private ExecutorService executorService;
    private static final int PORT = 4321;
    private ServerSocket serverSocket;

    public Server() throws IOException {
        serverSocket = new ServerSocket(PORT);
        executorService = Executors.newCachedThreadPool();
    }

    private static class ClientTread implements Runnable {
        Socket socket;

        public ClientTread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    try {
                        String get = dataInputStream.readUTF();
                        int ans = new Calculations(get).getFinalAnswer();
                        dataOutputStream.writeUTF(Integer.toString(ans));
                    } catch (EOFException E) {
                        dataInputStream.close();
                        break;
                    }
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                executorService.submit(new ClientTread(socket));
            } catch (IOException e) {
                System.out.println("Can't get client");
            }
        }
    }
}
