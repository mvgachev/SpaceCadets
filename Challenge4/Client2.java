/**
 * Represents a second client with a different port
 */
public class Client2 {
    public static void main(String[] args) {
        System.out.println("Trying to reach server...");
        new Client("", 3481);
    }
}