package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*; /*random*/ 
import com.toedter.calendar.JDateChooser; /* calender*/
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener {
 
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar;
    JLabel labelempid;
    JDateChooser dcdob; /*dcdob= date chooser date of birth*/
    JComboBox cbcourse, cbbranch; /*Course Drop down list, branch*/
    JButton submit, cancel;
    
    Random ran = new Random(); /* random class object auto genrater roll no */
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L); /* math.abs function postive print the rool no */
    
    AddTeacher() {
       
        /*To Create Frame */
        setSize(900, 700);
        setLocation(350, 50);
        
        /* to create layout*/
        setLayout(null);
        
        /* Headind from*/
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        /*name*/
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        /* Father name*/
        JLabel lblfname = new JLabel(" Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        /* Employee Id*/
        JLabel lblempid = new JLabel("Employee Id");
        lblempid.setBounds(50, 200, 200, 30);
        lblempid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempid);
        
        labelempid = new JLabel("101"+first4);
        labelempid.setBounds(200, 200, 200, 30);
        labelempid.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempid);
        
        /* Date Of Birth*/
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        /*calender*/
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
        
         /*Address*/
        JLabel lbladdress = new JLabel("Adress");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        /*Phone*/
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        /*Email id*/
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        /*Class 10th*/
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);
        
        /*Class 12th*/
        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);
        
        /*Aaddhar Number*/
        JLabel lblaadhar = new JLabel("Aaddhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        /*Qualification Drop down list*/
        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        String course [] = {"B.Tech", "BA", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "Mcom", "MA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE); /*drop down list color*/
        add(cbcourse);
        
         /*Department Drop down list*/
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String branch [] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE); /*drop down list color*/
        add(cbbranch);
        
        /* to create submit button*/
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK); /* set button background color*/
        submit.setForeground(Color.WHITE); /* button on font change color */
        submit.addActionListener(this); /* to click button login button*/
        submit.setFont(new Font("Tahoma", Font.BOLD, 15)); /* button on change font & size*/
        add(submit);
        
        /* to create cancelbutton*/
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK); /* set button background color*/
        cancel.setForeground(Color.WHITE); /* button on font change color */
        cancel.addActionListener(this); /* to click button login button*/
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15)); /* button on change font & size*/
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
           String name = tfname.getText();
           String fname = tffname.getText();
           String rollno = labelempid.getText();
           String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
           String address = tfaddress.getText();
           String phone = tfphone.getText();
           String email = tfemail.getText();
           String x = tfx.getText();
           String xii = tfxii.getText();
           String aadhar = tfaadhar.getText();
           String course = (String) cbcourse.getSelectedItem();
           String branch = (String) cbbranch.getSelectedItem();
           
           try{
              String query = "insert into teacher values('"+name+"', '"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+branch+"')";
              
              Conn con = new Conn();
              con.s.executeUpdate(query);
              
              JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
              setVisible(false);
           } catch (Exception e){
               e.printStackTrace();
           }
           
        } else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddTeacher();
    }
}