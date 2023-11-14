package atm.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel text,cardno,pin;
    JTextField cardTextField;
    JPasswordField pinPasswordField;
    JButton login, signup, clear;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(70, 10, 100, 100);
        add(lable);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 38));
        text.setBounds(200,40,450,40);
        add(text);
        
        JLabel cardno = new JLabel("Card No.:");
        cardno.setFont(new Font("BankGothic Lt BT", Font.BOLD, 28));
        cardno.setBounds(125,150,375,30);
        add(cardno);
        
        cardTextField = new JTextField(17);
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Brush Script MT", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("BankGothic Lt BT", Font.BOLD, 28));
        pin.setBounds(125,220,375,30);
        add(pin);
        
        pinPasswordField = new JPasswordField(15);
        pinPasswordField.setFont(new Font("Arial", Font.BOLD, 14));
        pinPasswordField.setBounds(300,220,230,30);
        add(pinPasswordField);
        
        login = new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        
        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        
        setLayout(null);
        
        login.setFont(new Font("MV Boli", Font.BOLD, 14));
        login.setBounds(300,300,100,30);
        add(login);
        
        clear.setFont(new Font("MV Boli", Font.BOLD, 14));
        clear.setBounds(430,300,100,30);
        add(clear);
        
        signup.setFont(new Font("MV Boli", Font.BOLD, 14));
        signup.setBounds(300,350,230,30);
        add(signup);
        
        login.addActionListener(this);
        clear.addActionListener(this);
        signup.addActionListener(this);
        
        Color customColor = new Color(224, 176, 255);
        getContentPane().setBackground(customColor);
        
        setSize(800, 480);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
              
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinPasswordField.setText("");
        }else if(ae.getSource()==login){
            Conn conn = new Conn();
                String cardno  = cardTextField.getText();
                String pin  = pinPasswordField.getText();
                String q = "select * from login where cardnumber = '" + cardno + "' and pin = '" + pin + "'";

                try{
                    ResultSet rs = conn.s.executeQuery(q);
                    if (rs.next()) {
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }
                }catch(Exception e) {
                    System.out.println(e);
                }
                
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        
        }
    }
    
    public static void main(String[] args){
        new Login().setVisible(true);
    }
}