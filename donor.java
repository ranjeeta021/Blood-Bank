import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class Donor extends JFrame implements ActionListener   //,ItemListener
{  
   String tgender;
 //  Choice gender=new Choice();
   Date dd=new Date();
   ButtonGroup grp=new ButtonGroup();
   JRadioButton rb1=new JRadioButton("Male");
   JRadioButton rb2=new JRadioButton("Female");
   JButton bnew=new JButton("New");
   JButton bdelete=new JButton("Delete");
   JButton bclear=new JButton("Clear");
   JButton bedit=new JButton("Edit");
   JButton bsearch=new JButton("Search");
   JButton bsave=new JButton("Save");
   JButton bcancel=new JButton("Cancel");
   JLabel lbldform=new JLabel("DONOR FORM"); 
   JLabel lblddate=new JLabel("Date:"); 
   JLabel s1=new JLabel("/"); 
   JLabel s2=new JLabel("/"); 
   JLabel _s1=new JLabel("/"); 
   JLabel _s2=new JLabel("/"); 
   JLabel lbldfather=new JLabel("Father's Name:"); 
   JLabel lbldoccupation=new JLabel("Occupation:"); 
   JLabel lbldno=new JLabel("Donor No.:");
   JLabel lbldname=new JLabel("Donor Name:");
   JLabel lblddob=new JLabel("D.O.B:");
   JLabel lbldgender=new JLabel("Gender:");
   JLabel lbldadd=new JLabel("Address:");
   JLabel lbldcity=new JLabel("City:");
   JLabel lbldstate=new JLabel("State:");
   JLabel lbldpin=new JLabel("PIN:");
   JLabel lbldcontact=new JLabel("Contact No.:");
   JLabel lbldemail=new JLabel("E-mail id:");
   JLabel lbldblood=new JLabel("Blood Group:");
   JTextField d=new JTextField();
   JTextField m=new JTextField();
   JTextField y=new JTextField();
   JTextField _d=new JTextField();
   JTextField _m=new JTextField();
   JTextField _y=new JTextField();
   JTextField txtdno=new JTextField();
   JTextField txtdname=new JTextField();
   //JTextField txtddob=new JTextField();
   JTextField txtdadd=new JTextField();
   JTextField txtdcity=new JTextField();
   JTextField txtdstate=new JTextField();
   JTextField txtdfather=new JTextField();
   JTextField txtdoccupation=new JTextField();
   JTextField txtdpin=new JTextField();
   JTextField txtdcontact=new JTextField();
   JTextField txtdemail=new JTextField();
   JTextField txtdblood=new JTextField();
   JLabel Bground=new JLabel(new ImageIcon("pic.png"));

   public static void main(String argv[])throws IOException
{
     Donor ob=new Donor();
}

   public Donor()
   {
     setLayout(null);
     setSize(2000,2000);
     lbldform.setFont(new Font("Times New Roman",Font.BOLD,30));
     s1.setFont(new Font("Times New Roman",Font.BOLD,25));
     s2.setFont(new Font("Times New Roman",Font.BOLD,25));
     _s1.setFont(new Font("Times New Roman",Font.BOLD,25));
     _s2.setFont(new Font("Times New Roman",Font.BOLD,25));
     lbldform.setBackground(new Color(200,150,100));  
     setVisible(true);
     bnew.setBounds(300,600,100,40);
     bdelete.setBounds(420,600,100,40);
     bedit.setBounds(540,600,100,40);
     bsearch.setBounds(660,600,100,40);
     bsave.setBounds(780,600,100,40);
     bcancel.setBounds(900,600,100,40);
     bclear.setBounds(1020,600,100,40);
     lbldform.setBounds(550,30,300,50);
     lblddate.setBounds(300,150,100,25);
     lbldno.setBounds(300,200,100,25);
     lbldname.setBounds(750,200,100,25);
     lblddob.setBounds(300,250,100,25);
     lbldfather.setBounds(750,300,100,25);
     lbldgender.setBounds(750,250,100,25);
     lbldoccupation.setBounds(300,300,100,25);
     lbldadd.setBounds(300,350,100,25);
     lbldcity.setBounds(750,350,100,25);
     lbldstate.setBounds(750,400,100,25);
     lbldpin.setBounds(300,450,100,25);
     lbldcontact.setBounds(300,500,100,25);
     lbldemail.setBounds(750,500,100,25);
     lbldblood.setBounds(300,550,100,25);
     d.setBounds(450,150,25,25);
     s1.setBounds(480,150,25,25);
     m.setBounds(500,150,25,25);
     s2.setBounds(530,150,25,25);
     y.setBounds(550,150,50,25);
	 
     _d.setBounds(450,250,25,25);
     _s1.setBounds(480,250,25,25);
     _m.setBounds(500,250,25,25);
     _s2.setBounds(530,250,25,25);
     _y.setBounds(550,250,50,25);
	 
     txtdno.setBounds(450,200,250,25);
     txtdname.setBounds(850,200,250,25);
 //    txtddob.setBounds(450,250,100,25);
     txtdfather.setBounds(450,300,100,25);
//     gender.setBounds(850,250,100,25);
	 rb1.setBounds(850,250,100,20);
	 rb2.setBounds(970,250,100,20);
     txtdoccupation.setBounds(850,300,100,25);
     txtdadd.setBounds(450,350,250,75);
     txtdcity.setBounds(850,350,250,25);
     txtdstate.setBounds(850,400,250,25);
     txtdpin.setBounds(450,450,250,25);
     txtdcontact.setBounds(450,500,250,25);
     txtdemail.setBounds(850,500,250,25);
     txtdblood.setBounds(450,550,75,25);

	 Bground.setBounds(0,0,1350,770);
	 
     add(bnew);
     add(bdelete);
     add(bedit);
     add(bsearch);
     add(bsave);
     add(bcancel);
     add(bclear);
     add(lbldform);
     add(lbldno);
     add(lblddate);
     add(lbldname);
     add(lblddob);
     add(lbldgender);
     add(lbldadd);
     add(lbldcity);
     add(lbldstate);
     add(lbldfather);
     add(lbldoccupation);
     add(lbldpin);
     add(lbldcontact);
     add(lbldemail);
     add(lbldblood);
     add(txtdno);
     add(txtdname);
 //    add(txtddob);
     add(txtdadd);
     add(txtdcity);
     add(txtdstate);
     add(txtdpin);
     add(txtdcontact);
     add(txtdemail);
     add(txtdfather);
     add(txtdoccupation);
     add(txtdblood);
//     add(gender);
	 add(rb1);
	 add(rb2);
	 grp.add(rb1);
	 grp.add(rb2);
	 
	 add(d);
	 add(s1);
	 add(m);
	 add(s2);
     add(y);
	 add(_d);
	 add(_s1);
	 add(_m);
	 add(_s2);
     add(_y);
	 
	 add(Bground);
	 rb1.setBackground(new Color(255,242,229));
	 rb2.setBackground(new Color(255,242,229));
	 
/*	 gender.add("Female");
     gender.add("Male");
     gender.addItemListener(this);*/
     bnew.addActionListener(this);
     bdelete.addActionListener(this);
     bsave.addActionListener(this);
     bcancel.addActionListener(this);
     bsearch.addActionListener(this);

     bedit.addActionListener(this);
     bclear.addActionListener(this);
	 
	 rb1.addActionListener(this);
	 rb2.addActionListener(this);
}
//--------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==rb1)
		tgender="Male";
	if(e.getSource()==rb2)
		tgender="Female";
if(e.getSource()==bnew)
{
   try
   { 
      
     int ctr=1;
     Connection con;
     con=DriverManager.getConnection("jdbc:odbc:blooddsn");
     ResultSet  res;
     Statement st=con.createStatement();
     res=st.executeQuery("Select * from donortbl");
     while(res.next())
     {
      ctr++;
     }
     txtdno.setText(""+ctr);
     txtdname.setText("");
     _d.setText("");
	 _m.setText("");
	 _y.setText("");
     txtdoccupation.setText("");
     txtdfather.setText("");
     txtdadd.setText("");
     txtdcity.setText("");
     txtdstate.setText("");
     txtdpin.setText("");
     txtdcontact.setText("");
     txtdemail.setText("");
     txtdblood.setText("");
	 DateFormat f1= new SimpleDateFormat("dd");
     d.setText(f1.format(dd));
	 //System.out.println("Day:"+(f1.format(dd)));
     DateFormat f2= new SimpleDateFormat("MM");
     m.setText(f2.format(dd));
	 DateFormat f3= new SimpleDateFormat("yyyy");
     y.setText(f3.format(dd)); 
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
	  	int dd,mm,yy,flg=0,_flg=0;
	  dd=Integer.parseInt(d.getText());
	  mm=Integer.parseInt(m.getText());
	  yy=Integer.parseInt(y.getText());
	  flg=check_Date(dd,mm,yy);
	  dd=Integer.parseInt(_d.getText());
	  mm=Integer.parseInt(_m.getText());
	  yy=Integer.parseInt(_y.getText());
	  _flg=check_Date(dd,mm,yy);
      int ctr=1;
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:blooddsn");
      //ResultSet  res;
      Statement st=con.createStatement();
      //res=st.executeQuery("Select * from donortbl");
      String str="insert into donortbl(ddate,dno,dname,ddob,dgender,dfather,doccupation,dadd,dcity,dstate,dpin,dcontact,demail,dblood,dlast)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(str);
	 
      ps.setInt(2,Integer.parseInt(txtdno.getText()));
      ps.setString(3,txtdname.getText());
 //     ps.setString(4,txtddob.getText());
      ps.setString(5,tgender);
      ps.setString(6,txtdoccupation.getText());
      ps.setString(7,txtdfather.getText());
      ps.setString(8,txtdadd.getText());
      ps.setString(9,txtdcity.getText());
      ps.setString(10,txtdstate.getText());
      ps.setString(11,txtdpin.getText());
      ps.setString(12,txtdcontact.getText());
      ps.setString(13,txtdemail.getText());
      ps.setString(14,txtdblood.getText());
      String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
	  ps.setString(1,tdate);	
	  ps.setString(15,tdate);
      String _tdate=_d.getText()+"/"+_m.getText()+"/"+_y.getText();
	  ps.setString(4,_tdate);	  
	  if((flg==1)&&(_flg==1))
	  {
		  ps.executeUpdate();
          JOptionPane.showMessageDialog(null,"saved succesfully");
		  this.dispose();
	  }
	  else
	  {
		  if(flg!=1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid Date!");
		  }
		  else if(_flg!=1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid Date Of Birth!");
		  }
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
		ResultSet res=st.executeQuery("select * from donortbl where dno="+txtdno.getText());
		while(res.next())
		{
		   txtdno.setText(String.valueOf(res.getInt("dno")));
		   txtdname.setText(res.getString("dname"));
		   String ch=res.getString("dgender");
		   if(ch.equalsIgnoreCase("Male"))
			rb1.setSelected(true);
		   else if(ch.equalsIgnoreCase("Female"))
			rb2.setSelected(true);
		   String date=res.getString("ddate");
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

		   String _date=res.getString("ddob");
		   String _dd,_mm,_yy;
		   int _i1,_i2;
		   _i1=_date.indexOf('/');
		   _i2=_date.lastIndexOf('/');
		   _dd=_date.substring(0,_i1);
		   _mm=_date.substring((_i1+1),_i2);
		   _yy=_date.substring((_i2+1));
		   _d.setText(_dd);
		   _m.setText(_mm);
		   _y.setText(_yy);		   
		   
		 //  txtddob.setText(res.getString("ddob"));
		   txtdadd.setText(res.getString("dadd"));
		   txtdfather.setText(res.getString("dfather"));
		   txtdoccupation.setText(res.getString("doccupation"));
		   txtdcity.setText(res.getString("dcity"));
		   txtdstate.setText(res.getString("dstate"));
		   txtdpin.setText(res.getString("dpin"));
		   txtdcontact.setText(res.getString("dcontact"));
		   txtdemail.setText(res.getString("demail"));
		   txtdblood.setText(res.getString("dblood"));
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

if(e.getSource()==bedit)
{
 try
 {
	  int dd,mm,yy,flg=0,_flg=0;
	  dd=Integer.parseInt(d.getText());
	  mm=Integer.parseInt(m.getText());
	  yy=Integer.parseInt(y.getText());
	  flg=check_Date(dd,mm,yy);
	  dd=Integer.parseInt(_d.getText());
	  mm=Integer.parseInt(_m.getText());
	  yy=Integer.parseInt(_y.getText());
	  _flg=check_Date(dd,mm,yy);

	  String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
	  String _tdate=_d.getText()+"/"+_m.getText()+"/"+_y.getText();
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:blooddsn");
      Statement st=con.createStatement();
      String str="update donortbl set dname='"+txtdname.getText()+"',dgender='"+tgender+"',dfather='"+txtdfather.getText()+"',doccupation='"+txtdoccupation.getText()+"',dno='"+txtdno.getText()+"',ddob='"+_tdate+"',ddate='"+tdate+"',dlast='"+tdate+"',dadd='"+txtdadd.getText()+"',dcity='"+txtdcity.getText()+"',dstate='"+txtdstate.getText()+"',dpin='"+txtdpin.getText()+"',dcontact='"+txtdcontact.getText()+"',demail='"+txtdemail.getText()+"',dblood='"+txtdblood.getText()+"' where dno="+txtdno.getText();
      PreparedStatement ps=con.prepareStatement(str);
	  if((flg==1)&&(_flg==1))
	  {
		  ps.executeUpdate();
          JOptionPane.showMessageDialog(null,"Modified succesfully");
	  }
	  else
	  {
		  if(flg!=1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid Date!");
		  }
		  else if(_flg!=1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid Date Of Birth!");
		  }

	  }
      
  }
catch(Exception eea)
{
System.out.println(eea);
}
}
if(e.getSource()==bclear)
{
  txtdno.setText("");
  txtdname.setText("");
  d.setText("");
  m.setText("");
  y.setText("");
  _d.setText("");
  _m.setText("");
  _y.setText("");

  txtdadd.setText("");
  txtdcity.setText("");
  txtdpin.setText("");
  txtdstate.setText("");
  txtdcontact.setText("");
  txtdemail.setText("");
  txtdfather.setText("");
  txtdoccupation.setText("");
  txtdblood.setText("");
}
if(e.getSource()==bdelete)
{
	try
	{
	
	        Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from donortbl where dno="+txtdno.getText());
		if(res.next())
		{
		String str="delete from donortbl where dno="+txtdno.getText();
                PreparedStatement ps=con.prepareStatement(str);
		ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
		}
		else
	        JOptionPane.showMessageDialog(null,"No such Donor No.");
	}
	catch(Exception ee)
	{
	        System.out.println(ee);
        }
} 	
if(e.getSource()==bcancel)
{
this.dispose();
}
}
//________________________________________________________________________________________________________________

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*public void itemStateChanged(ItemEvent ie)
{
if(gender.getSelectedItem()=="Female")
  {
  tgender="Female";
  }
else
  {
  tgender="Male";
  }
}*/
public static int check_Date(int dd, int mm, int yy)
{
	int flg=0;
	  if(yy<=2030)
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
	  return(flg);
}

}