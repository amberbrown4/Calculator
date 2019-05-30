import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class Client implements Linker {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    Socket socket;
    InetAddress inetAddress  = InetAddress.getLocalHost();

    @Override
    public String doLink(String s) {
        try {
            dataOutputStream.writeUTF(s);
            System.out.println("karim");
            String out = dataInputStream.readUTF();
            System.out.println(out);
            return out;
        } catch (IOException e){
            System.out.println("Cannot read/write from/to server");
        }
        return "Cannot DO Anything with server";
    }

    public Client() throws IOException {
        socket = new Socket(inetAddress.getHostAddress(),4321);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

}
