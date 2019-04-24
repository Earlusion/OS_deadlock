
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

    static Queue<Integer> tunnel = new LinkedList<Integer>();
    static int[] flag = new int[2];

    public static void main(String[] args) {
        flag[0] = 0;
        flag[1] = 1;

        Thread right_cars = new Thread(new Right_Cars(20, flag, tunnel));
        right_cars.start();

        Thread left_cars = new Thread(new Left_Cars(20, flag, tunnel));
        left_cars.start();

    }
}

class Right_Cars implements Runnable {
    Queue<Integer> carLine = new LinkedList<Integer>();
    int numCars;
    int[] flag;
    Queue<Integer> tunnel;

    public Right_Cars(int numCars, int[] flag, Queue<Integer> tunnel) {
        this.numCars = numCars;
        this.tunnel = tunnel;
        this.flag = flag;

        // for (int i = 1; i <= numCars; i += 2) {
        // carLine.add(i);
        // }
    }

    // Finishes run only when flag is 1
    public void run() {
        int car_count = 0;
        int rCar_tracker = 1;

        try {
            while (car_count <= numCars) {
                Thread.sleep(1500);
                carLine.add(rCar_tracker);
                car_count++;

                System.out.println("Right-bound Car " + rCar_tracker + " wants to enter the tunnel.");
                rCar_tracker += 2;

                // Lock
                while (flag[1] == 0)
                    ;

                // Crit section
                rCar_tracker = carLine.poll();

                // Car is travelling
                tunnel.add(rCar_tracker);
                System.out.println("Right-bound Car " + rCar_tracker + " is in the tunnel.");
                Thread.sleep(2000);

                System.out.println("Right-bound Car " + rCar_tracker + " is exiting the tunnel.");
                flag[1] = 0;
                flag[0] = 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Left_Cars implements Runnable {
    Queue<Integer> carLine = new LinkedList<Integer>();
    int numCars;
    int[] flag;
    Queue<Integer> tunnel;

    public Left_Cars(int numCars, int[] flag, Queue<Integer> tunnel) {
        this.numCars = numCars;
        this.tunnel = tunnel;
        this.flag = flag;

        // for (int i = 0; i <= numCars; i += 2)
        //     carLine.add(i);
    }

    // Finishes run only when flag is 1
    public void run() {
        int car_count = 0;
        int rCar_tracker = 1;

        try {
            while (carLine.size() > 0) {
                Thread.sleep(2000);
                carLine.add(rCar_tracker);
                car_count++;

                System.out.println("Right-bound Car " + rCar_tracker + " wants to enter the tunnel.");
                rCar_tracker += 2;

                // Lock
                while (flag[0] == 0)
                    ;

                // Crit section
                rCar_tracker = carLine.poll();

                // Car is travelling
                tunnel.add(rCar_tracker);
                System.out.println("Right-bound Car " + rCar_tracker + " is in the tunnel.");
                Thread.sleep(2000);

                System.out.println("Right-bound Car " + rCar_tracker + " is exiting the tunnel.");
                flag[0] = 0;
                flag[1] = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
