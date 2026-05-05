package labirentgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class UsedLabirentPanel extends JPanel {
    private int[][] labirent;
    private int size = 25;
    private int PlayerX = 1, PlayerY = 1;
    private Runnable onWin; // Oyuncu kazandığında tetiklenecek olay

    // Constructor'a Runnable eklendi
    public UsedLabirentPanel(int[][] ilkLabirent, Runnable onWin){
        this.labirent = ilkLabirent; // Sınıfın asıl dizisine ilk haritayı atadık
        this.onWin = onWin;
        
        setPreferredSize(new Dimension(labirent[0].length * size, labirent.length * size));
        
        setFocusable(true);
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent event){
                int key = event.getKeyCode();
                
                // 2. Artık buradaki 'labirent' kelimesi ezberlenen eski parametreyi değil,
                // doğrudan sınıfın değişebilen 'this.labirent' değişkenini temsil ediyor.
                if((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && labirent[PlayerY - 1][PlayerX] == 0) PlayerY--;
                if((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && labirent[PlayerY + 1][PlayerX] == 0) PlayerY++;
                if((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && labirent[PlayerY][PlayerX - 1] == 0) PlayerX--;
                if((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && labirent[PlayerY][PlayerX + 1] == 0) PlayerX++;
                
                // Bitiş Noktası Koordinatları
                int bitisX = labirent[0].length - 2;
                int bitisY = labirent.length - 2;
                
                if(PlayerX == bitisX && PlayerY == bitisY) {
                    if(onWin != null) {
                        onWin.run(); 
                    }
                } else {
                    repaint(); 
                }
            }
        });
    }

    // Dışarıdan yeni harita yüklemek için kullanacağımız metod
    public void setLabirent(int[][] yeniLabirent) {
        this.labirent = yeniLabirent;
        this.PlayerX = 1; // Oyuncuyu başlangıca al
        this.PlayerY = 1;
        repaint(); // Ekranı yeni haritayla çiz
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int y = 0; y < labirent.length; y++){
            for(int x = 0; x < labirent[0].length; x++){
                if(labirent[y][x] == 1){
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(x * size, y * size, size, size);
            }
        }
        g.setColor(Color.GREEN);
        g.fillOval(PlayerX * size, PlayerY * size, size, size);
        
        g.setColor(Color.RED);
        g.fillRect((labirent[0].length - 2) * size, (labirent.length - 2) * size, size, size);
    }
}