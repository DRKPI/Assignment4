/**Assignmenet4 Alice UVU Help BOT
 * Created by David Koch on 11/25/2015.
 *
 */

import java.net.*;
import java.io.*;

public class AliceServer {
    public static void main(String[] args) {
        //For testing purposes: set to false before turn in
        boolean debug = true;

        try(
                //create a server on port 9000
                ServerSocket serverSocket = new ServerSocket(9000);

                //when there is a connection from server(wait till then)
                Socket clientSocket = serverSocket.accept();

                //open writer to write to client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                //create reader to read from client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        )//end try
        {
            String inputLine;
            int count=0;//using to tell if first connection communication

            //while there is input from client, send it back to client
            while((inputLine = in.readLine()) != null){
                //if first communication output intro
                if(count == 0) {
                    out.println("You are now connected to Alice. How can I help you? ");
                }
                else{


                    //Print result to query
                    out.println("Alice: ");
                }

                count++;
            }
        }catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end AliceServer main method
}//end AliceServer class
