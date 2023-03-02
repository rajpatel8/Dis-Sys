import java.io.*;
import java.net.*;
import java.util.*;
 
public class CalculatorServer {
    // initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null ;
    private DataOutputStream out = null;
    
    // constructor with port
    public CalculatorServer(int port) {
        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");
            // takes input from the client socket
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
            String line = "";
            // reads message from client until "Over" is sent
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                    String[] tokens = line.split(" ");
                    int result = 0;
                    if (tokens[1].equals("+")) {
                        result = Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
                    } else if (tokens[1].equals("-")) {
                        result = Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
                    } else if (tokens[1].equals("*")) {
                        result = Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]);
                    } else if (tokens[1].equals("/")) {
                        result = Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]);
                    }
                    out.writeUTF(Integer.toString(result));
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            // close connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        CalculatorServer server = new CalculatorServer(5500);
    }
}   