
package labirentgame;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author emird
 */
public class LabirentGEN {
    private int width,height;
    private int[][] labirent;
    
    //Rastgele yön seçimi
    private Random r = new Random();
    
    public LabirentGEN(int width,int height){
        this.height = height;
        this.width = width;
        labirent = new int[height][width];
        //Her yer duvar olacak
        for(int i = 0;i < height;i++){
            Arrays.fill(labirent[i], 1);
        }
    }
    //Rastgele üretilen labirentin hangi noktadan oyulmaya başlayacağı ile ilgilenir
    public void uret(int StartX,int StartY){
        carve(StartX,StartY);
    }
    //Öz yineleme metodu, labirenti depth first search(dfs) algoritması ile oyar ve çıkış yolu bulur
    private void carve(int x,int y){
        // 0 -> sağ , 1 -> sol, 2 -> aşağı,3 -> yukarı
        int[] girdi = {0,1,2,3}; 
        //Yönleri karıştırıyoruz labirent her seferinde farklı olsun diye
        karistir(girdi);
        for(int g : girdi){
            int dx = 0,dy = 0;
            switch(g){
                case 0: dx = 1;break; //sağ
                case 1: dx = -1;break;//sol
                case 2: dy = 1;break;//aşağı
                case 3: dy = -1;break;//yukarı
            }
            //Yeni koordinatlar 2 adım ötesinde olmalı
            int nx = x + dx*2; 
            int ny = y + dy * 2;
            if(nx > 0 && ny > 0 && nx < width - 1 && ny < height - 1 && labirent[ny][nx] == 1){
                labirent[y + dy][x + dx] = 0; // duvarı yol yap
                labirent[ny][nx] = 0; //hedefi yol yap
                carve(nx,ny); // 2 adım öteden devam et recursive(öz yineleme)
            }
        }
    }
    //Dizideki sayıları karıştırmak için
    private void karistir(int[] arr){
        for(int i = arr.length -1;i > 0;i--){
            int j = r.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public int[][] getLabirent(){
        return labirent;
    }
}
