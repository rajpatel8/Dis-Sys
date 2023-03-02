import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started");
        
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");
        
        // Receive file name from client
        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String fileName = br.readLine();
        
        // Open output stream and write to file
        FileOutputStream fileOut = new FileOutputStream(fileName);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            fileOut.write(buffer, 0, bytesRead);
        }
        fileOut.close();
        System.out.println("File received");
        
        // Close connections
        br.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
}

