/*
 * Main.java
 *
 * Created on 10 November 2024, 19:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package copyfile;

/**
 *
 * @author fatbo
 */
import java.io.*;
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
        System.out.println("ADa");
        File fname1 = new File("C:\\temp2\\Deleteme.jpg");
        File fname2 = new File("C:\\temp2\\Test2\\Deleteme.jpg");
        
        System.out.println("Timer task started at:"+new Date());
        long startTime = System.currentTimeMillis();
        
        int i = 1;
        double filesize1 = fname1.length();
        double Totalsize1 = filesize1;
        double TotalsizeM = 0;
        long elapsetime = 0;
        boolean xx = true;
        
        while (xx) {

        startTime = System.currentTimeMillis();
                
        String str1 = "C:\\temp2\\Test2\\Deleteme" ;
        String str2 = (str1 + Integer.toString(i) + ".jpg");
        
        fname2 = new File(str2);
        
        try {
            copyFileUsingStream(fname1, fname2);
        } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
        };
        elapsetime = System.currentTimeMillis() - startTime;
        
        Totalsize1 = Totalsize1 + filesize1;
        TotalsizeM = Totalsize1/(1024*1024);
 
        i++;
        
        if (i<8 && elapsetime<20000) {
            xx = true;
        } else {
            xx = false;
        }
        
        }   //end of while
        
        // wait for activity here
        long endTime = System.currentTimeMillis();
        long seconds = (endTime - startTime) / 1000; 

        System.out.println("Timer task finished at:"+new Date());
        System.out.println("Task took seconds:"+seconds);
        System.out.println("Total Size :" +Totalsize1 + " bytes");
        System.out.println("Total Size :" +TotalsizeM + " Mega bytes");
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source);
        os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
        
  //    try {
     // Thread.sleep(1000);
  //  } catch (InterruptedException e) {
  //    Thread.currentThread().interrupt();
  //  }
    }
}
}
