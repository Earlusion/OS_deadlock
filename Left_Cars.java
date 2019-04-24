import java.util.ArrayList;

public class Left_Cars extends Car {
    ArrayList<Integer> cars = new ArrayList<Integer>();

    public Left_Cars(int numCars, ArrayList<Integer> tunnel) {
        this.numCars = numCars;
        this.tunnel = tunnel;
        flag[0] = 0;

        for(int i = 0; i < numCars; i += 2)
            cars.add(i);
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
