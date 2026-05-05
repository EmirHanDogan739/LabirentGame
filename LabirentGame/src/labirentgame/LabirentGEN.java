
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
    public void uret(int StartX,int StartY){
        carve(StartX,StartY);
    }
    private void carve(int x,int y){
        int[] girdi = {0,1,2,3};
        karistir(girdi);
        for(int g : girdi){
            int dx = 0,dy = 0;
            switch(g){
                case 0: dx = 1;break;
                case 1: dx = -1;break;
                case 2: dy = 1;break;
                case 3: dy = -1;break;
            }
            int nx = x + dx*2;
            int ny = y + dy * 2;
            if(nx > 0 && ny > 0 && nx < width - 1 && ny < height - 1 && labirent[ny][nx] == 1){
                labirent[y + dy][x + dx] = 0;
                labirent[ny][nx] = 0;
                carve(nx,ny);
            }
        }
    }
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
