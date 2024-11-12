/*
 * Main.java
 *
 * Created on 12 November 2024, 09:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package timewait;

/**
 *
 * @author fatbo
 */
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Calling LongWait Timer task at:"+new Date());
        long startTime = System.currentTimeMillis();
        LongWait(10000);
        // wait for activity here
        long endTime = System.currentTimeMillis();
        long seconds = (endTime - startTime) / 1000; 

        System.out.println("Timer task finished at:"+new Date());
        System.out.println("Task took seconds:"+seconds);
    }
        
    
    public static void LongWait (long seconds2){
           try {
      Thread.sleep(seconds2);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    }
    
}
