package labirentgame;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TimeManager {
    private Timer timer;
    private int lft_time;

    // Parametrelere 'Runnable onTimeUp' eklendi
    public TimeManager(JLabel label, int st_Timer, Runnable onTimeUp) {
        lft_time = st_Timer;
        int delay = 1000; // 1 saniye(1000 milisaniye)
        
        timer = new Timer(delay, (ActionEvent timing) -> {
            lft_time--;
            label.setText(String.valueOf(lft_time));
            
            if(lft_time < 0) {
                timer.stop();
                label.setText("Süre bitti!");
                
                // System.exit(0) kaldırıldı.
                // Yerine dışarıdan gelen kod bloğu tetikleniyor:
                if (onTimeUp != null) {
                    onTimeUp.run();
                }
            }
        });
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    public void setTimer(int t){
        lft_time = t;
        
    }
}