/**
 * Created by Koch on 11/25/2015.
 */
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadFromFile {
    //Method readFromFile
    //Purpose: read file, create thread pool, and send properly sized chunks to individual threads
    public void readFromFile(int size, BufferedReader br, int numThreads, String fileName){
        //Variables
        ArrayList<String> fileLines = new ArrayList<String>();
        String sCurrentLine = "temp";
        MyThread callThread;
        int i = 0;

        //Create Thread pool object to create specified number of threads
        ExecutorService service = Executors.newFixedThreadPool(numThreads);

        //Check for errors while opening, reading, and closing file
        try {

            while (sCurrentLine != null) {
                sCurrentLine = br.readLine();

                //Read from file stream
                // save line to array list
                fileLines.add(sCurrentLine);
                i++;//incrementor to keep track of chunkSize to send to thread

                //when i equals size send fileLines to a thread to be processed
                if (i == size){
                    try {
                        callThread = new MyThread(fileLines, fileName);
                        service.execute(callThread);

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Thread did not run!");
                    }

                    i = 0;
                    fileLines = new ArrayList<>();//need new ArrayList for next chunk
                }
            }// end while loop
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //Shutdown the thread pool so no more items added to queue
        service.shutdown();
        //while loop locks access till threads complete their tasks
        while(!service.isTerminated()){

        }
    }//end readFromFile method
}
