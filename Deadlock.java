/*
Marco Colasito and Amanda Seasholtz
CS 4345: Operating Systems
Spring '19
Assignment 4
*/

import java.util.ArrayList;

public class Deadlock {
    static ArrayList<Thread> threads = new ArrayList<Thread>();

    static ArrayList<Integer> tunnel = new ArrayList<Integer>();

    public static void main(String[] args) {

            Car left_cars = new Left_Cars(20, tunnel);
            threads.add(left_cars);

            Car right_cars = new Right_Cars(20, tunnel);
            threads.add(right_cars);

        for (Thread t : threads)
            t.start();
    }
}
