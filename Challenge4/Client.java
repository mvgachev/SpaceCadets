import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * Represents a client with a username.
 * Has a specific port with which to connect to the {@link Server}.
 */
public class Client {

    /**
     * Constructs a new client with a specific address and port to connect to.
     *
     * @param address takes the address as a string (In this case there is no address because it takes it automatically)
     * @param port    takes the port number as an integer
     */
    public Client(String address, int port) {

        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;
        String username = getUsername();
        try {
            //Connects

            socket = new Socket(address, port);
            if (socket.isConnected()) {
                System.out.println("Connected");
            } else throw new IOException("The server has not been reached!");

            //Takes input from terminal
            input = new DataInputStream(System.in);

            //Sends output to socket
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Sends the username first
        //After that checks until the input is equal to "over" and stops
        String line = username;
        while (!line.equals("over")) {
            try {
                assert output != null;
                output.writeUTF(line);
                System.out.print("Type your message: ");
                line = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Closes everything
        try {
            socket.close();
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes the username of the user
     */
    private String getUsername() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = input.next();
        return username;
    }

    public static void main(String[] args) {
        new Client("", 3480);
    }
}