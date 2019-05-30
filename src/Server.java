import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private static final int PORT = 4321;

    private ServerSocket serverSocket;

    public Server() throws IOException {
        serverSocket = new ServerSocket(PORT);
    }

    String get = "u9i";

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    try{
                    get = dataInputStream.readUTF();
                    int ans = new Calculations(get).getFinalAnswer();
                    dataOutputStream.writeUTF(Integer.toString(ans));
                    }catch (EOFException E){
                        dataInputStream.close();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Can't get client");
            }
        }
    }
}
