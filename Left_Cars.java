import java.util.LinkedList;
import java.util.Queue;

public class Left_Cars extends Car {
    Queue<Integer> carLine = new LinkedList<Integer>();

    public Left_Cars(int numCars, Queue<Integer> tunnel) {
        this.numCars = numCars;
        this.tunnel = tunnel;
        flag[0] = 0;

        for(int i = 0; i < numCars; i += 2)
            carLine.add(i);
    }

    // Finishes run only when flag is 1
    public void run() {
        int carCount = 0;

        try{
            while(carLine.size() > numCars){
                Thread.sleep(3000);

                carLine.add(carCount++);

                while(true){
                    if(flag[0] == 1)
                    break;
                }
                tunnel.add(carLine.poll());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // public String created(){
    //     return "Left-Bound Car " + num + " wants to enter the tunnel.";
    // }

    // public String enters(){
    //     return "Left-Bound Car " + num + " is in the tunnel.";
    // }

    // public String leaves(){
    //     return "Left-Bound Car " + num + " is exiting the tunnel.";
    // }
}
