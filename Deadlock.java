/*
Marco Colasito and Amanda Seaholtz
CS 4345: Operating Systems
Spring '19
Assignment 4
*/

//import java.io.*;
import java.util.ArrayList;

public class Deadlock {
    static ArrayList<Thread> threads = new ArrayList<Thread>();

    public static void main(String[] args) {

        for (int i = 0; i < 20; i += 2) {
            Car left_cars = new Left_Car(i);
            threads.add(left_cars);
        }

        for (int i = 1; i < 20; i += 2) {
            Car right_cars = new Right_Car(i);
            threads.add(right_cars);
        }

        for (Thread t : threads)
            t.start();
    }
}
