package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; /* awt is subpackage event*/
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, cancel; /* gobal declare*/
    JTextField tfusername, tfpassword;
    
    /* Create To Frame */
    Login () {
        
        getContentPane().setBackground(Color.WHITE); /* Frame color change */
        setLayout(null); 
        
        JLabel lblusername = new JLabel("Username"); /* write username */
        lblusername.setBounds(40, 20, 100, 20); /* to set username left distance, top distance, label width, lebel height*/ 
        add(lblusername);
        
        /* to create input box */
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password"); /* write Password */
        lblpassword.setBounds(40, 70, 100, 20); /* to set username left distance, top distance, label width, lebel height*/ 
        add(lblpassword);
        
        /* to create input box */
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);
        
        /* to create loginbutton*/
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK); /* set button background color*/
        login.setForeground(Color.WHITE); /* button on font change color */
        login.addActionListener(this); /* to click button login button*/
        login.setFont(new Font("Tahoma", Font.BOLD, 15)); /* button on change font & size*/
        add(login);
        
        /* to create cancel button*/
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK); /* set button background color*/
        cancel.setForeground(Color.WHITE); /* button on font change color */
        cancel.addActionListener(this); /* to click button cancel button*/
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15)); /* button on change font & size*/
        add(cancel);
        
        /* To set Login image*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg")); /*image class i1 object*/
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }
            
            
            
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password"); /* invalid unsername password*/
                    setVisible(false);
                }
              
                
            } catch (Exception e) {
               e.printStackTrace();
            }
        } else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }        
            
            
    public static void main(String[] args){
        new Login();
    }
}