/**Assignmenet4 Alice UVU Help BOT
 * Created by David Koch on 11/25/2015.
 */
import java.net.*;
import java.io.*;

public class AliceClient {
    public static void main(String[] args) {
        //For testing purposes: set to false before turn in
        boolean debug = true;

        //Variables
        String ipAddress = args[0];
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        BufferedReader stdIn = null;
        String userInput = "";

        //Check if num of arguments is correct
        if(args.length != 1){
            System.out.println("You need to only provide the IP address you are trying to connect with to continue.");
            System.exit(1);
        }else {
            try {
                try {
                    //create a connection to server
                    clientSocket = new Socket(ipAddress, 9000);
                }catch(ConnectException ce){
                    System.out.println("Unable to connect to server. Check the IP address and try again.");
                    ce.printStackTrace();
                }finally{
                    System.exit(1);
                }

                //open a stream for writing characters to server
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                //create a reader to read characters back from server
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                //create a reader to read from console on the client side
                stdIn = new BufferedReader(new InputStreamReader(System.in));

                // Create regex for bye, goodbye type key words for quitting program
                String quitPattern = ".*bye*.*";

                //For debugging purposes
                if (debug) {

                }

                while (userInput != null) {
                    //read from command line
                    userInput = stdIn.readLine();
                    //send user input to server (communicate with server)
                    out.println(userInput);
                    //read input from server and print
                    System.out.println(in.readLine());
                }

            } catch (UnknownHostException ue) {
                ue.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Client Socket did not close properly.");
                    e.printStackTrace();
                }
            }
        }//end else for correct initial input

    }//end AliceClient main method
}//end AliceClient class