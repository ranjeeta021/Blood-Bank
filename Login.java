import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{  
     int ctr;
	 JButton blogin=new JButton("Login");
	 JButton bcancel=new JButton("Cancel");
	 JLabel lblform=new JLabel("Login Form"); 
	 JLabel lblname=new JLabel("User Name:");
	 JLabel lblpass=new JLabel("Password:");
	 JTextField tname=new JTextField();
     JPasswordField tpass=new JPasswordField();
	 JLabel limg=new JLabel(new ImageIcon("pic.png"));
	 public static void main(String argv[])throws IOException
	 {
		 Login ob=new Login();
	 }
	 public Login()
	 {
		 ctr=0;
		 setLayout(null);
		 setSize(2000,2000);
		 lblform.setFont(new Font("Times New Roman",Font.BOLD,50));
		 lblform.setBackground(new Color(200,150,100));  
		 lblname.setFont(new Font("Times New Roman",Font.BOLD,20));
		 lblpass.setFont(new Font("Times New Roman",Font.BOLD,20));
		 setVisible(true);
		 lblform.setBounds(350,100,500,100);
		 lblname.setBounds(250,300,150,30);
		 lblpass.setBounds(250,375,150,30);
		 tname.setBounds(430,300,250,30);
		 tpass.setBounds(430,375,250,30);
		 blogin.setBounds(400,600,100,40);
         bcancel.setBounds(530,600,100,40);
		 limg.setBounds(0,0,1350,770);
		 add(blogin);
		 add(bcancel);
		 add(lblform);
		 add(lblname);
		 add(lblpass);
		 add(tname);
		 add(tpass);
		 add(limg);
		 blogin.addActionListener(this);
         bcancel.addActionListener(this);

	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 
		 if(e.getSource()==bcancel)
		 {
			 this.dispose();
		 }
		 if(e.getSource()==blogin)
		 {
			
			 if(ctr<2)
			 {
				 
				int flag=0;
				 try
				 {
			     Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
				 Statement st=con.createStatement();
				 String strpass=String.valueOf(tpass.getPassword());
				 ResultSet res=st.executeQuery("select * from logintbl where strcomp(username ,'"+tname.getText()+"',0)=0 and strcomp(password,'"+strpass+"',0)=0");
				 while(res.next())
				 {
					 flag=1;
					
				 }
				 if(flag==1)
				 {
					 JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFULLY");
					 tname.setText("");
					 tpass.setText("");
					 this.dispose();
					 new Mnu();
				 }
				 else
				 {
					 ctr++;
					 JOptionPane.showMessageDialog(null,"WRONG USERNAME OR PASSWORD");
					 tname.setText("");
					 tpass.setText("");
				 }
				 }
				 catch(SQLException ae)
				 {
					 JOptionPane.showMessageDialog(null,ae);
				 }
				 /*if(flg==1)
					 new Mnu();*/
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(null,"You have entered incorrect details 3 times!!");
				 this.dispose();
			 }
		     tname.setText("");
		     tpass.setText("");
		 }	 		 
	 } 
}
