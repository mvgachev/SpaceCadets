/**
 * A class that threads the server, so that multiple clients can reach it at the same time.
 */
public class Threading {

    public Threading() {
        Thread newThread;
        //Create a need thread for the server
        //Sets a new port for the server
        for (int port = 3480; port < 3486; port++) {
            newThread = new Thread(new Server(port));
            newThread.start();
        }
        System.out.println("Waiting for clients...");
    }

    public static void main(String[] args) {
        Threading servers = new Threading();
    }
}
