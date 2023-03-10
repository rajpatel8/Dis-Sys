import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to server");
        
        // Send file name to server
        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(out, true);
        pw.println("Sample.txt");
        
        // Open input stream and read from file
        FileInputStream fileIn = new FileInputStream("/Users/aj/Desktop/Destro/LAB/week-2/Sample.txt");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileIn.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        fileIn.close();
        System.out.println("File sent");
        
        // Close connections
        pw.close();
        out.close();
        socket.close();
    }
}
