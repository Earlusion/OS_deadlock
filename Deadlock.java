
/*
Marco Colasito and Amanda Seasholtz
CS 4345: Operating Systems
Spring '19
Assignment 4
*/

import java.util.LinkedList;
import java.util.Queue;

public class Deadlock {
    // static ArrayList<Thread> threads = new ArrayList<Thread>();

    static int tunnel = 0;
    static int[] flag = new int[2];

    public static void main(String[] args) {
        flag[0] = 0;
        flag[1] = 1;

        Thread right_cars = new Thread(new Right_Cars(10, flag, tunnel));
        right_cars.start();

        Thread left_cars = new Thread(new Left_Cars(10, flag, tunnel));
        left_cars.start();

    }
}

class Right_Cars implements Runnable {
    Queue<Integer> carLine = new LinkedList<Integer>();
    int numCars;
    int car_count;
    int rCar_tracker;
    boolean done;

    int[] flag;
    int tunnel;

    public Right_Cars(int numCars, int[] flag, int tunnel) {
        this.numCars = numCars;
        this.tunnel = tunnel;
        this.flag = flag;

        this.car_count = 0;
        this.rCar_tracker = 1;
    }

    // Finishes run only when flag is 1
    public void run() {

        try {
            while (car_count < numCars) {
                Thread.sleep(1500);

                // Add car to wait queue and increment car counter
                carLine.add(rCar_tracker);
                car_count++;

                System.out.println("Right-bound Car " + rCar_tracker + " wants to enter the tunnel.\n");
                Thread.sleep(600);
                synchronized (flag) {

                    // Lock
                    if (flag[0] != -1)
                        while (flag[1] == 0)
                            ;

                    // Crit section
                    rCar_tracker = carLine.poll();

                    // Car is travelling
                    tunnel = rCar_tracker;
                    System.out.println("Right-bound Car " + rCar_tracker + " is in the tunnel.\n");
                    Thread.sleep(1000);
                }

                // Car exits tunnel, clear tunnel, release Left lock
                System.out.println("Right-bound Car " + rCar_tracker + " is exiting the tunnel.\n");
                tunnel = -1;
                rCar_tracker += 2;

                flag[1] = 0;
                flag[0] = 1;
            }
            flag[1] = -1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Right-bound line empty!\n");
    }
}

class Left_Cars implements Runnable {
    Queue<Integer> carLine = new LinkedList<Integer>();
    int numCars;
    int car_count;
    int lCar_tracker;

    int[] flag;
    int tunnel;

    public Left_Cars(int numCars, int[] flag, int tunnel) {
        this.numCars = numCars;
        this.tunnel = tunnel;
        this.flag = flag;

        this.car_count = 0;
        this.lCar_tracker = 0;
    }

    // Finishes run only when flag is 1
    public void run() {

        try {
            while (car_count <= numCars) {
                Thread.sleep(2500);

                // Add car to wait queue and increment car counter
                carLine.add(lCar_tracker);
                car_count++;

                System.out.println("Left-bound Car " + lCar_tracker + " wants to enter the tunnel.\n");
                Thread.sleep(500);

                System.out.println(flag[1]);
                synchronized (flag) {

                    // Lock
                    if (flag[1] != -1)
                        while (flag[0] == 0)
                            ;

                    
                    // Crit section
                    lCar_tracker = carLine.poll();

                    // Car is travelling
                    tunnel = lCar_tracker;
                    System.out.println("Left-bound Car " + lCar_tracker + " is in the tunnel.\n");
                    Thread.sleep(1500);
                }

                // Car exits tunnel, clear tunnel, release Left lock
                System.out.println("Left-bound Car " + lCar_tracker + " is exiting the tunnel.\n");
                tunnel = -1;
                lCar_tracker += 2;

                flag[0] = 0;
                flag[1] = 1;

            }
            flag[0] = -1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Left-bound line empty!\n");
    }
}
