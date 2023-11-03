package university.management.system;

import javax.swing.*;
import java.awt.*;

/*To create First Frame */
public class Splash extends JFrame implements Runnable {
    
    Thread t;
    Splash () {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg")); /*image class i1 object*/
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true); /*to show frame*/
        
        int x = 1;
        for(int i =2; i <= 600; i+=4, x+=1){
            setLocation(600 - ((i + x)/2),  350 - (i/2)); /*left side upper side*/
            setSize(i + 3*x, i + x/2); /*Length & width*/
            
            try{
                Thread.sleep(10);
                
            } catch (Exception e) {}
        }
        
        
    }
    
    /*Multithreading method */
    public void run() {
        try {
            Thread.sleep(7000); /* to open frame 7 second */
            setVisible(false); /* to close frame*/
            
            // Next Frame//
            new Login();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args){
        new Splash();
    }
}
