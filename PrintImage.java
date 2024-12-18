/*
 * HelloWorldPrinter.java
 *
 * Created on 06 November 2024, 14:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author fatbo */
 
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.print.*;
import java.io.*;
import javax.imageio.*;
 
public class PrintImage implements Printable, ActionListener {
 
 
    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        
        BufferedImage img = null;
try {
    img = ImageIO.read(new File("C:\\temp2\\Deleteme.jpg"));
} catch (IOException e) {
}
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
       
   //     g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        g.drawImage(img,10,10,null);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        /* Now we perform our rendering */

        g.drawString("Hello world!2", 20, 600);
        g.drawString(".", 100, 400);
       
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
 
    public void actionPerformed(ActionEvent e) {
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
    }
 
    public static void main(String args[]) {
  
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        JFrame f = new JFrame("Hello World Printer");
        f.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JButton printButton = new JButton("Print Hello World");
        printButton.addActionListener(new PrintImage());
        f.add("Center", printButton);
        f.pack();
        f.setVisible(true);
    }
  }  