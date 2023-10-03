import java.io.*;
import java.net.*;

public class SimpleServer{
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while(true){
                
                Socket ClientSocket = serverSocket.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(),true);

                String message = in.readLine();

                System.out.println("Received Nessage From Client: "+message);

                out.println("Server Saya!: hello Client");

                ClientSocket.close();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}