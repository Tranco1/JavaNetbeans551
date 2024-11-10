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
        
        try {
            copyFileUsingStream(fname1, fname2);
        } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
        }
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
    }
}
}
