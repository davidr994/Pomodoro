import javax.sound.sampled.AudioInputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Pomodoro implements Runnable {

    private String threadName;
    private Thread t;
    private int time;

    Pomodoro(String threadName) {
        this.threadName = threadName;
        System.out.println(threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            while (true) {

                for (int time = 1; time <= 30; time++) {
                    if (time <= 25) {
                        System.out.println("Thread: " + threadName + " minute: " + time);
                        Thread.sleep(200);
                    } else if (time > 25) {
                        System.out.println("Thread: " + threadName + " break minute: " + (time - 25));
                        Thread.sleep(200);
                    }
                }
                if (time == 30) continue;
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void sound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Users/david/Desktop/Basic-call-vibration (online-audio-converter.com).wav"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this.threadName);
            t.start ();
        }
    }
}
