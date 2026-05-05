package labirentgame;
import java.awt.BorderLayout;
import labirentgame.TimeManager;
import java.awt.Label;
import javax.management.timer.TimerMBean;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;


public class Pencere extends javax.swing.JFrame {
    private final int Lb1_Initial_Time = 70;
    private boolean isRandom = false;
    private boolean isNormalGame = false;
    // BUNU EKLE: Timer'ı sınıf seviyesine alıyoruz ki Geri butonu da görebilsin
    private TimeManager timer;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Pencere.class.getName());
    
    public Pencere() {
        
        initComponents();
        jButton3.setVisible(false);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        seviyeCounter = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LabirentGame");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setLabelFor(jButton1);
        jLabel1.setText("Süre");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        seviyeCounter.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        seviyeCounter.setText("1");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("SEVİYE :");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Başlat");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Random Üret");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("GERİ");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(seviyeCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                .addContainerGap(1348, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(seviyeCounter))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// Timer başlatılırken süre bitince ne olacağı Runnable olarak veriliyor
isNormalGame = true;
        if(!isRandom && isNormalGame){
            // BAŞTAKİ 'TimeManager' KELİMESİNİ SİLDİK, DİREKT 'timer =' YAPTIK
            timer = new TimeManager(jLabel1, Lb1_Initial_Time, () -> {
                jPanel1.removeAll(); 
                jPanel1.revalidate();
                jPanel1.repaint();
                
                jButton1.setText("Tekrar Başlayınız");
                jButton1.setVisible(true);
                jButton2.setVisible(true); // Random butonunu da geri getir
                jButton3.setVisible(false); // Süre bitince Geri butonunu gizle
            });
            // Oyun başlarken sayacı 1 yap
            seviyeCounter.setText("1");
            timer.start();
            
            jPanel1.removeAll();
            // Runnable ekleyerek LabirentPanel'i çağırıyoruz
        LabirentPanel lb = new LabirentPanel(() -> {
            // LabirentPanel'den bölüm geçildi haberi gelince sayacı artır
            int guncelSeviye = Integer.parseInt(seviyeCounter.getText());
            seviyeCounter.setText(String.valueOf(guncelSeviye + 1));
        });
            
            jPanel1.add(lb,BorderLayout.CENTER);
            jPanel1.revalidate();
            jPanel1.repaint();
            
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }
        
        if(isNormalGame || isRandom){
            jButton3.setVisible(true);
        } else {
            jButton3.setVisible(false);
        }
    
        
        /*
        // İlk labirenti üret
        LabirentGEN Seviye = new LabirentGEN(31, 31);
        Seviye.uret(1, 1);
        
        // UsedLabirentPanel'i sınıf seviyesinde (global) veya final bir dizi içinde tutmaya
        // gerek kalmadan direkt oluşturup Runnable olayını tanımlıyoruz:
        UsedLabirentPanel oyunPaneli = new UsedLabirentPanel(Seviye.getLabirent(), new Runnable() {
            @Override
            public void run() {
                // BU KOD KIRMIZI NOKTAYA DEĞİNCE ÇALIŞIR
                System.out.println("Tebrikler! Yeni harita oluşturuluyor...");
                // Yeni bir DFS labirenti üret
                LabirentGEN yeniSeviye = new LabirentGEN(31, 31);
                yeniSeviye.uret(1, 1);
                timer.setTimer(60);
                // Paneli silmeden sadece içindeki diziyi değiştir (Performans artışı)
                UsedLabirentPanel p = (UsedLabirentPanel) jPanel1.getComponent(0);
                p.setLabirent(yeniSeviye.getLabirent());
                
                // Not: Eğer istersen burada TimeManager süresine +10 saniye falan da ekleyebilirsin!
            }
        });
        
        // Paneli ekrana ekle
        jPanel1.add(oyunPaneli, java.awt.BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();
        
        // ÖNEMLİ: Eklenen panelin klavye tuşlarını dinleyebilmesi için odağı ona ver
        oyunPaneli.requestFocusInWindow();
        */
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
isRandom = true;
        if(isRandom && !isNormalGame){
            // YİNE BAŞTAKİ 'TimeManager' KELİMESİNİ SİLDİK
            timer = new TimeManager(jLabel1, Lb1_Initial_Time, () -> {
                jPanel1.removeAll(); 
                jPanel1.revalidate();
                jPanel1.repaint();
                
                jButton2.setText("Tekrar Başlayınız");
                jButton1.setVisible(true); // Başlat butonunu da geri getir
                jButton2.setVisible(true);
                jButton3.setVisible(false); // Süre bitince Geri butonunu gizle
            });
            
            timer.start();
            
            LabirentGEN Seviye = new LabirentGEN(31, 31);
            Seviye.uret(1, 1);
            // Oyun başlarken sayacı 1 yap
            seviyeCounter.setText("1");
            UsedLabirentPanel oyunPaneli = new UsedLabirentPanel(Seviye.getLabirent(), new Runnable() {
            @Override
            public void run() {
                System.out.println("Tebrikler! Yeni harita oluşturuluyor...");
                
                // Random modda kırmızı noktaya değince sayacı artır
                int guncelSeviye = Integer.parseInt(seviyeCounter.getText());
                seviyeCounter.setText(String.valueOf(guncelSeviye + 1));
                
                LabirentGEN yeniSeviye = new LabirentGEN(31, 31);
                yeniSeviye.uret(1,1);
                timer.setTimer(60);
                UsedLabirentPanel p = (UsedLabirentPanel ) jPanel1.getComponent(0);
                p.setLabirent(yeniSeviye.getLabirent());
            }
        });
            
            jPanel1.add(oyunPaneli, java.awt.BorderLayout.CENTER);
            jPanel1.revalidate();
            jPanel1.repaint();
            
            oyunPaneli.requestFocusInWindow();
            jButton2.setVisible(false);
            jButton1.setVisible(false);
        }
        
        if(isNormalGame || isRandom){
            jButton3.setVisible(true);
        } else {
            jButton3.setVisible(false);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  // 1. Süreyi durdur ve etiketi sıfırla
        if (timer != null) {
            timer.stop();
        }
        jLabel1.setText("Süre"); 
        // Menüye dönünce sayacı tekrar 1'e sabitle
        seviyeCounter.setText("1");
        // 2. Oyun panelini (labirenti) temizle
        jPanel1.removeAll();
        jPanel1.revalidate();
        jPanel1.repaint();

        // 3. Durumları sıfırla
        isNormalGame = false;
        isRandom = false;
        
        // 4. Ana menü butonlarını geri getir ve metinlerini düzelt
        jButton1.setText("Başlat");
        jButton1.setVisible(true);
        
        jButton2.setText("Random Üret");
        jButton2.setVisible(true);
        
        // 5. Geri butonunu artık gizle
        jButton3.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Pencere().setVisible(true));
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel seviyeCounter;
    // End of variables declaration//GEN-END:variables
}
