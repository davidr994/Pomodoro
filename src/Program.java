import java.io.File;

public class Program {


    public static void main(String[] args) throws Exception {
        Pomodoro time1 = new Pomodoro("Pomodoro Timer");
        time1.sound();
        time1.start();
        time1.sound();

        time1.run();



    }
}
