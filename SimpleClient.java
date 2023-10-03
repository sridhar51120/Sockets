import java.net.*;
import java.io.*;

public class SimpleClient{
    public static void main(String[] arg){
        try{
            Socket socket = new Socket("localhost", 1234);

            while(true){
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

                out.println("Hello Server!");

                String Response = in.readLine();
                
                System.out.println("Server response: "+Response);

            }
            
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
