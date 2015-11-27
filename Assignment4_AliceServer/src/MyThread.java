/**
 * Created by Koch on 11/25/2015.
 */
import java.io.*;
import java.util.ArrayList;

public class MyThread implements Runnable {
    //Class variables
    private final ArrayList<String> myChunk;
    private String fileName;

    //Threads Constructor
    public MyThread(ArrayList<String> chunk, String name){
        fileName = name;
        this.myChunk = chunk;
    }//end constructor


    public void run(){


    }//end run method
}
