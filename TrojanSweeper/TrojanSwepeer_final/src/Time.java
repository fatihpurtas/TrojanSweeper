import java.util.Timer;
import java.util.TimerTask;

public class Time extends Timer {

    private static int a = 0;
    private Timer timer;
    private TimerTask timerTask;

    public void timerResume() {
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                TrojanPlace.totalTime.setText("Time: " + a);
                a++;
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    public void oneTime() {
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {

            }
        };
        timer.schedule(timerTask, 0);
    }

    public void stopTimer() {
        a = 0;
        timerTask.cancel();
        timer.cancel();
    }
}