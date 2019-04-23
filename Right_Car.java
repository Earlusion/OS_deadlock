import java.util.ArrayList;

public class Right_Car extends Car {
    ArrayList<Integer> cars;

    public Right_Car(int num) {
        this.num = num;
        this.timer = 0;
        flag[1] = 1;
    }

    public String created(){
        return "Right-Bound Car " + num + " wants to enter the tunnel.";
    }

    public String enters(){
        return "Right-Bound Car " + num + " is in the tunnel.";
    }

    public String leaves(){
        return "Right-Bound Car " + num + " is exiting the tunnel.";
    }
}
