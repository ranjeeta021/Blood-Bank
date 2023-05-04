import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
public class Bill extends JFrame implements ActionListener,ItemListener
{     String typ;
      Date dd=new Date();
      Choice type=new Choice();
	  
	  JLabel Bground=new JLabel(new ImageIcon("pic.png"));
      JButton bnew=new JButton("New");
      JButton bdelete=new JButton("Delete");
      JButton bclear=new JButton("Clear");
      JButton bedit=new JButton("Edit");
      JButton bsearch=new JButton("Search");
      JButton bsave=new JButton("Save");
      JButton bcancel=new JButton("Cancel");
	  JLabel s1=new JLabel("/"); 
      JLabel s2=new JLabel("/"); 

      JLabel lblbibill=new JLabel("BILL"); 
      JLabel lblbino=new JLabel("Bill.No.:");
      JLabel lblbistatus=new JLabel("Pay Status:");
	  JLabel lblbidate=new JLabel("Date:"); 
      JLabel lblbiamount=new JLabel("Amount:"); 
      JLabel lblbitype=new JLabel("Type:");
      JLabel lblpno=new JLabel("Issued To:");
	  JLabel lblbipatient=new JLabel("(Patient No.)");
	  JLabel lblbireferred=new JLabel("Referred By:"); 	  
	  JTextField txtbino=new JTextField();
      JTextField txtbistatus=new JTextField();
	  JTextField d=new JTextField();
	  JTextField m=new JTextField();
	  JTextField y=new JTextField();
      JTextField txtbiamount=new JTextField();
	  JTextField txtbitype=new JTextField();
	  JTextField txtpno=new JTextField();
  	  JTextField txtbireferred=new JTextField();
	  
   public static void main(String argv[])throws IOException
{
     Bill ob=new Bill();
}

   public Bill()
   {
     setLayout(null);
     setSize(2000,2000);
     lblbibill.setFont(new Font("Times New Roman",Font.BOLD,30));
     lblbipatient.setFont(new Font("Comic Sans MS",Font.ITALIC,10));
     lblbibill.setBackground(new Color(200,150,100));  
     s1.setFont(new Font("Times New Roman",Font.BOLD,25));
     s2.setFont(new Font("Times New Roman",Font.BOLD,25));
     setVisible(true);
     bnew.setBounds(300,600,100,40);
     bdelete.setBounds(420,600,100,40);
     bedit.setBounds(540,600,100,40);
     bsearch.setBounds(660,600,100,40);
     bsave.setBounds(780,600,100,40);
     bcancel.setBounds(900,600,100,40);
     bclear.setBounds(1020,600,100,40);
	 
     lblbibill.setBounds(600,30,200,50);
     lblbino.setBounds(300,150,100,25);
     lblbidate.setBounds(700,150,100,25);
     lblbireferred.setBounds(300,200,100,25);
     lblpno.setBounds(700,200,100,25);
	 lblbipatient.setBounds(700,230,100,25);
     lblbitype.setBounds(300,250,100,25);
     lblbiamount.setBounds(300,300,100,25);
     lblbistatus.setBounds(700,300,100,25);
	 
     txtbino.setBounds(425,150,250,25);
     d.setBounds(825,150,25,25);
     s1.setBounds(855,150,25,25);
     m.setBounds(875,150,25,25);
     s2.setBounds(905,150,25,25);
     y.setBounds(925,150,50,25);

	 txtbireferred.setBounds(425,200,250,25);
     txtpno.setBounds(825,200,250,25);
	 type.setBounds(425,250,250,25);
	 txtbiamount.setBounds(425,300,250,25);
     txtbistatus.setBounds(825,300,250,25);
	 Bground.setBounds(0,0,1350,770);




	     add(bnew);
         add(bdelete);
         add(bedit);
         add(bsave);
         add(bcancel);
         add(bclear);
         add(bsearch);
		 
         add(lblbibill);
         add(lblbino);
         add(lblbistatus);
         add(lblbidate);
         add(lblbiamount);
         add(lblbitype);
         add(lblpno);
         add(lblbipatient);
         add(lblbireferred);
		      add(txtbino);
              add(txtbistatus);
                 add(d);
				 add(s1);
				 add(m);
				 add(s2);
				 add(y);
              add(txtbiamount);
              add(type);
              add(txtpno);
              add(txtbireferred);
							type.add("RBC");
							type.add("Plasma");
							type.add("Platelets");
			  add(Bground);
							
							type.addItemListener(this);
							bnew.addActionListener(this);
							bdelete.addActionListener(this);
							bsave.addActionListener(this);
							bcancel.addActionListener(this);
							bedit.addActionListener(this);
							bsearch.addActionListener(this);
							bclear.addActionListener(this);
   }
							public void actionPerformed(ActionEvent e)
{
if(e.getSource()==bnew)
{
   try
   {
      int ctr=1;
      Connection con;
     con=DriverManager.getConnection("jdbc:odbc:blooddsn");
     ResultSet  res;
     Statement st=con.createStatement();
     res=st.executeQuery("Select * from billtbl");
     while(res.next())
     {
      ctr++;
     }
     txtbistatus.setText("");
     DateFormat f1= new SimpleDateFormat("dd");
     d.setText(f1.format(dd));
     DateFormat f2= new SimpleDateFormat("MM");
     m.setText(f2.format(dd));
	 DateFormat f3= new SimpleDateFormat("yyyy");
     y.setText(f3.format(dd)); 
	 DateFormat f4= new SimpleDateFormat("yy");
	 String s=f4.format(dd)+""+ctr;
     txtbino.setText(""+s);

     txtbiamount.setText("");
     txtpno.setText("");
     txtbireferred.setText("");
   }
     catch(Exception ee)
 {
}
}
//___________________________________________________________________________________________________________

if(e.getSource()==bsave)
{
      try
   {
	   int dd,mm,yy,flg=0;
	  dd=Integer.parseInt(d.getText());
	  mm=Integer.parseInt(m.getText());
	  yy=Integer.parseInt(y.getText());
	  if(yy<=2016)
	  {
		  if(mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12)
		  {
			  if(dd<=31)
			  {
				  flg=1;
			  }
		  }
		  if(mm==4||mm==6||mm==9||mm==11)
		  {
			  if(dd<=30)
			  {
				  flg=1;
			  }
		  }
		  if(mm==2)
		  {
			  if(yy%4==0)
			  {
				  if(dd<=29)
				  {
					  flg=1;
				  }
			  }
			  else
			  {
				  if(dd<=28)
				  {
					  flg=1;
				  }
			  }
		  }
	  }

      int ctr=1;
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:blooddsn");
      ResultSet  res;
      Statement st=con.createStatement();
      res=st.executeQuery("Select * from billtbl");
      String str="insert into billtbl(bino,bidate,pno,bireferred,bistatus,bitype,biamount)values(?,?,?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(str);
      ps.setString(1,txtbino.getText());
      ps.setInt(3,Integer.parseInt(txtpno.getText()));
      ps.setString(4,txtbireferred.getText());
      ps.setString(5,txtbistatus.getText());
	  ps.setString(6,typ);
	  ps.setString(7,txtbiamount.getText());
      String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
	  ps.setString(2,tdate);	  
	  if(flg==1)
	  {
		  ps.executeUpdate();
          JOptionPane.showMessageDialog(null,"saved succesfully");
	  }
	  else
	  {
		  JOptionPane.showMessageDialog(null,"Invalid Date!");
	  }
    }
    catch(Exception eee)
    {
     System.out.println(eee);
    }
}
//________________________________________________________________________________________________________________________

if(e.getSource()==bsearch)
{
	try
	{
		int flag=0;
		Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from billtbl where bino='"+txtbino.getText()+"'");
		while(res.next())
		{
		   txtbino.setText(res.getString("bino"));
		   String date=res.getString("bidate");
		   String dd,mm,yy;
		   int i1,i2;
		   i1=date.indexOf('/');
		   i2=date.lastIndexOf('/');
		   dd=date.substring(0,i1);
		   mm=date.substring((i1+1),i2);
		   yy=date.substring((i2+1));
		   d.setText(dd);
		   m.setText(mm);
		   y.setText(yy);		   

		   txtpno.setText(String.valueOf(res.getInt("pno")));
		   txtbireferred.setText(res.getString("bireferred"));
		   txtbiamount.setText(res.getString("biamount"));
		   txtbistatus.setText(res.getString("bistatus"));
		   String str=res.getString("bitype");
		   if(str.equals("RBC"))
		   {
			type.select(0);
		   }
		   else if(str.equals("Plasma"))  
		   {			   //type.getSelectedItem().equals("Plasma")
			type.select(1);
		   }
		   else 
		   {
			type.select(2);
		   }
		   flag=1;
		}
		if(flag==0)
		JOptionPane.showMessageDialog(null,"No such Data");
	}
 	catch(Exception eeee)
	{
		System.out.println(eeee);
	}
}
//_______________________________________________________________________________________________________________

if(e.getSource()==bcancel)
{
this.dispose();
}
//________________________________________________________________________________________________________________
if(e.getSource()==bedit)
{
 try
 {
	 int dd,mm,yy,flg=0;
	  dd=Integer.parseInt(d.getText());
	  mm=Integer.parseInt(m.getText());
	  yy=Integer.parseInt(y.getText());
	  if(yy<=2016)
	  {
		  if(mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12)
		  {
			  if(dd<=31)
			  {
				  flg=1;
			  }
		  }
		  if(mm==4||mm==6||mm==9||mm==11)
		  {
			  if(dd<=30)
			  {
				  flg=1;
			  }
		  }
		  if(mm==2)
		  {
			  if(yy%4==0)
			  {
				  if(dd<=29)
				  {
					  flg=1;
				  }
			  }
			  else
			  {
				  if(dd<=28)
				  {
					  flg=1;
				  }
			  }
		  }
	  }
	  typ=type.getSelectedItem();
	  String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:blooddsn");
      Statement st=con.createStatement();
      String str="update billtbl set bitype='"+typ+"',bidate='"+tdate+"',pno="+txtpno.getText()+",bireferred='"+txtbireferred.getText()+"',bistatus='"+txtbistatus.getText()+"',biamount='"+txtbiamount.getText()+"' where bino='"+txtbino.getText()+"'";
      PreparedStatement ps=con.prepareStatement(str);
	  if(flg==1)
	  {
		  ps.executeUpdate();
          JOptionPane.showMessageDialog(null,"Modified succesfully");
	  }
	  else
	  {
		  JOptionPane.showMessageDialog(null,"Invalid Date!");
	  }
 
  }
catch(Exception eea)
{
System.out.println(eea);
}
}
if(e.getSource()==bclear)
{
  txtbino.setText("");
  d.setText("");
  m.setText("");
  y.setText("");
  txtbireferred.setText("");
  txtpno.setText("");
  txtbiamount.setText("");
  txtbistatus.setText("");
}
if(e.getSource()==bdelete)
{
	try
	{
	
	        Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from billtbl where bino='"+txtbino.getText()+"'");
		if(res.next())
		{
		String str="delete from billtbl where bino='"+txtbino.getText()+"'";
                PreparedStatement ps=con.prepareStatement(str);
		ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
		}
		else
		
	        JOptionPane.showMessageDialog(null,"No such Bill No.");
	    }
	catch(Exception ee)
	    {
	        System.out.println(ee);
        }
} 	
}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public void itemStateChanged(ItemEvent ie)
{
if(type.getSelectedItem()=="RBC")
  {
  typ="RBC";
  }
else if(type.getSelectedItem()=="Plasma")
  {
  typ="Plasma";
  }
  else
  {
	  typ="Platelets";
  }
}
}




 

