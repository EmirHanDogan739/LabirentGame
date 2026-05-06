package labirentgame;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TimeManager {
    private Timer timer;
    private int lft_time;

   
    public TimeManager(JLabel label, int st_Timer, Runnable onTimeUp) {
        lft_time = st_Timer;
        int delay = 1000; // 1 saniye(1000 milisaniye)
        
        timer = new Timer(delay, (ActionEvent timing) -> {
            lft_time--;//süreyi birer birer azalt
            label.setText(String.valueOf(lft_time));//labelde sayı göstermek için kullandık
            
            if(lft_time < 0) {
                timer.stop();
                label.setText("Süre bitti!");
                
                
                // Yerine dışarıdan gelen kod bloğu tetikleniyor:
                if (onTimeUp != null) {
                    onTimeUp.run();
                }
            }
        });
    }
    //Süre başlatma
    public void start() {
        timer.start();
    }
//süre durdurma
    public void stop() {
        timer.stop();
    }
    //süre değiştirme
    public void setTimer(int t){
        lft_time = t;
        
    }
}