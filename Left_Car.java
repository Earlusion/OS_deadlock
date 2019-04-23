import java.util.ArrayList;

public class Left_Car extends Car {
    ArrayList<Car> cars;

    public Left_Car(int num) {
        this.num = num;
        this.timer = 0;
        flag[0] = 0;
    }

    public String created(){
        return "Left-Bound Car " + num + " wants to enter the tunnel.";
    }

    public String enters(){
        return "Left-Bound Car " + num + " is in the tunnel.";
    }

    public String leaves(){
        return "Left-Bound Car " + num + " is exiting the tunnel.";
    }
}