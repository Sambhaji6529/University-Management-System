package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {
    
    Choice cEmpid, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    TeacherLeave(){
        
        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        /* Apply Leave Student*/
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        /*search by emp id*/
        JLabel lblempid = new JLabel("Search by Employee Id");
        lblempid.setBounds(60, 100, 200, 20);
        lblempid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblempid);
        
        cEmpid = new Choice();
        cEmpid.setBounds(60, 130, 200, 20);
        add(cEmpid);
        
        /*separte sql table in roll no column*/
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpid.add(rs.getString("EmpId"));
            }
        } catch(Exception e){
            e.printStackTrace();
        } 
        
        /* calender*/
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);
        
        /*time duration half/full day*/
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        /* to create submit button*/
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK); /* set button background color*/
        submit.setForeground(Color.WHITE); /* button on font change color */
        submit.addActionListener(this); /* to click button login button*/
        submit.setFont(new Font("Tahoma", Font.BOLD, 15)); /* button on change font & size*/
        add(submit);
        
        /* to create cancelbutton*/
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK); /* set button background color*/
        cancel.setForeground(Color.WHITE); /* button on font change color */
        cancel.addActionListener(this); /* to click button login button*/
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15)); /* button on change font & size*/
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit) {
           String rollno =cEmpid.getSelectedItem();
           String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
           String duration = ctime.getSelectedItem();
           
           String query = "insert into teacherleave values('"+rollno+"', '"+date+"', '"+duration+"')";
           
           try{
               Conn c = new Conn();
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Leave Confirmed");
               setVisible(false);
           } catch(Exception e){
               setVisible(false);
               
           }
           
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new TeacherLeave();
}
    
}

