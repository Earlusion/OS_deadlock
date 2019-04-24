import java.util.ArrayList;

public class Right_Cars extends Car {
    ArrayList<Integer> cars = new ArrayList<Integer>();

    public Right_Cars(int numCars, ArrayList<Integer> tunnel) {
        this.numCars = numCars;
        this.tunnel = tunnel;
        flag[1] = 1;

        for(int i = 1; i < numCars; i += 2)
            cars.add(i);
    }

    

    // public String created(){
    //     return "Right-Bound Car " + num + " wants to enter the tunnel.";
    // }

    // public String enters(){
    //     return "Right-Bound Car " + num + " is in the tunnel.";
    // }

    // public String leaves(){
    //     return "Right-Bound Car " + num + " is exiting the tunnel.";
    // }
}
