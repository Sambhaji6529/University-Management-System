package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    
    Choice cEmpId;
    JTable table;
    JButton search, print, cancel; /* button name*/
    
    TeacherLeaveDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        /*search by employee id */
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        cEmpId = new Choice();
        cEmpId.setBounds(180, 20, 150, 20);
        add(cEmpId);
        
        /*separte sql table in empid column*/
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpId.add(rs.getString("empid"));
            }
        } catch(Exception e){
            e.printStackTrace();
        } 
        
        /*table*/
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        /*search button*/
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        /*print button*/
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
      
        
        /*cancel button*/
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        /*search button*/
        if (ae.getSource() == search){
            String query = "select * from teacherleave where empid = '"+cEmpId.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e){
                e.printStackTrace();
            }
        
         /* print button */   
        } else if(ae.getSource() == print){
            try {
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
         
         
         /*cancel button*/
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new TeacherLeaveDetails();
    }
    
}