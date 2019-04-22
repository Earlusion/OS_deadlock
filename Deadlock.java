/*
Marco Colasito and Amanda Seaholtz
CS 4345: Operating Systems
Spring '19
Assignment 4
*/

//import java.io.*;
import java.util.ArrayList;

public class Deadlock{
    static ArrayList<Thread> threads = new ArrayList<Thread>();
    public static void main(String[] args){

        Thread left_cars = new Thread(new Traffic(20));
        threads.add(left_cars);

        Thread right_cars = new Thread(new Traffic(20));
        threads.add(right_cars);

        for (Thread t : threads)
			t.start();

    }
}

class Traffic implements Runnable {

    public Traffic(int num_cars) {
    
    }

    public void run() {
        
    }
}