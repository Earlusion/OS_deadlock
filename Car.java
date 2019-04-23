public abstract class Car extends Thread{
    int num;
    int[] flag;
    int timer;

    // public void ageTime(){
    //     timer += 3;
    // }

    public abstract String created();

    public abstract String enters();

    public abstract String leaves();
}
