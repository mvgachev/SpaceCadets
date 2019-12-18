import java.net.*;
import java.io.*;

/**
 * Represents a Server that is threaded.
 * Takes the data from the clients and print it to the console in the proper format.
 */
public class Server implements Runnable {

    private int port;
    private String username;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        Socket socket = null;
        ServerSocket serverSocket = null;
        DataInputStream input = null;

        //The server socket accepts the given socket from the specific port if there is one
        try {
            //Makes the connection
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Takes the data from the client
        try {
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Takes the username first
        try {
            username = input.readUTF();
            System.out.println(username + " has joined the chat.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Until the user types "over" prints everything written
        String line = "";
        while (!line.equals("over")) {
            try {
                line = input.readUTF();
                System.out.println(username + ": " + line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
