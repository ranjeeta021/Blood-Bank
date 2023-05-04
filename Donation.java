import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*; 
//import jitupack.*;
public class Donation extends JFrame implements ActionListener
{
	String days;
	Date dd=new Date();
	JLabel Bground=new JLabel(new ImageIcon("pic.png"));
	JButton bnew=new JButton("New");
//	JButton bclear=new JButton("Clear");
	JButton bdelete=new JButton("Delete");
	JButton bedit=new JButton("Edit");
	JButton bsearch=new JButton("Search");
	JButton bsave=new JButton("Save");
	JButton bcancel=new JButton("Cancel");
	JButton brefresh=new JButton("Refresh");
   JButton bnewdonor=new JButton("New Donor?");
   JButton bbloodform=new JButton("Blood Form");
	
	JLabel lblbddonation=new JLabel("BLOOD  DONATION");
	JLabel lblbddate=new JLabel("Date:"); 
   JLabel s1=new JLabel("/"); 
   JLabel s2=new JLabel("/"); 
    JLabel _s1=new JLabel("/"); 
   JLabel _s2=new JLabel("/"); 
	JLabel lbldno=new JLabel("Donor No.:"); 
	JLabel lblbno=new JLabel("Blood Unit No.:");
	JLabel lblbdlast=new JLabel("Last Donated:");
	JLabel lblbdelapse=new JLabel("Time Elapse:");
	JLabel lblbdsince=new JLabel("(Since Last Donation)");
	JLabel lblbdage=new JLabel("Age:");
	JLabel lblbdunit=new JLabel("No. Of Units:");
	JTextField d=new JTextField();
    JTextField m=new JTextField();
    JTextField y=new JTextField();
	 JTextField _d=new JTextField();
   JTextField _m=new JTextField();
   JTextField _y=new JTextField();
	JTextField txtdno=new JTextField();
	JTextField txtbno=new JTextField();
	//JTextField txtbdlast=new JTextField();
	JTextField txtbdelapse=new JTextField();
	JTextField txtbdage=new JTextField();
	JTextField txtbdunit=new JTextField();

	public static void main(String argv[])throws IOException
	{
		Donation ob=new Donation();
	}

	public Donation()
	{
		setLayout(null);
		setSize(2000,2000);
		lblbddonation.setFont(new Font("Times New Roman",Font.BOLD,30));
		lblbddonation.setBackground(new Color(200,150,100));  
		s1.setFont(new Font("Times New Roman",Font.BOLD,25));
        s2.setFont(new Font("Times New Roman",Font.BOLD,25));

		_s1.setFont(new Font("Times New Roman",Font.BOLD,25));
        _s2.setFont(new Font("Times New Roman",Font.BOLD,25));

		setVisible(true);
		bnew.setBounds(300,500,100,40);
		bedit.setBounds(420,500,100,40);
		bsearch.setBounds(540,500,100,40);
		bsave.setBounds(660,500,100,40);
		bdelete.setBounds(900,500,100,40);
//		bclear.setBounds(1040,500,100,40);
		bcancel.setBounds(780,500,100,40);
		lblbddonation.setBounds(500,40,300,25);
		lblbddate.setBounds(700,150,50,25);
		lbldno.setBounds(300,150,100,25);
		brefresh.setBounds(470,200,80,25);
	    bnewdonor.setBounds(330,200,110,25);
		bbloodform.setBounds(1000,200,110,25);

		lblbno.setBounds(700,200,100,25);
		lblbdlast.setBounds(300,250,100,25);
		lblbdelapse.setBounds(700,250,100,25);
		lblbdsince.setBounds(700,270,200,25);
		lblbdage.setBounds(300,320,100,25);
		lblbdunit.setBounds(700,320,100,25);
		 d.setBounds(880,150,25,25);
		 s1.setBounds(910,150,25,25);
		 m.setBounds(930,150,25,25);
		 s2.setBounds(960,150,25,25);
		 y.setBounds(980,150,50,25);
		 
		 _d.setBounds(430,250,25,25);
         _s1.setBounds(460,250,25,25);
         _m.setBounds(480,250,25,25);
         _s2.setBounds(510,250,25,25);
         _y.setBounds(530,250,50,25);
	 
		 txtdno.setBounds(430,150,100,25);
		 txtbno.setBounds(880,200,100,25);
		// txtbdlast.setBounds(430,250,100,25);
		 
		 txtbdelapse.setBounds(880,250,100,25);
		 txtbdage.setBounds(430,320,100,25);
		 txtbdunit.setBounds(880,320,100,25);
		 Bground.setBounds(0,0,1350,770);

		add(bnew);
		add(bedit);
		add(bsearch);
		add(bsave);
//		add(bclear);
		add(bdelete);
		add(bcancel);
		add(brefresh);
	    add(bnewdonor);
		add(bbloodform);
		add(lblbddonation);
		add(lblbddate);
		add(lbldno);
		add(lblbno);
		add(lblbdlast);
		add(lblbdelapse);
		add(lblbdsince);
		add(lblbdage);
		add(lblbdunit);
		
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

		add(txtdno);
		add(txtbno);
		//add(txtbdlast);
		add(txtbdelapse);
		add(txtbdage);
		add(txtbdunit);
		
		add(Bground);
		
		//txtbno.setText(bbuno);
		bnew.addActionListener(this);
		bsave.addActionListener(this);
		bedit.addActionListener(this);
		bdelete.addActionListener(this);
//		bclear.addActionListener(this);
		bcancel.addActionListener(this);
		bsearch.addActionListener(this);
		brefresh.addActionListener(this);
        bnewdonor.addActionListener(this);
     	bbloodform.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
		   try
		   {
			 DateFormat f1= new SimpleDateFormat("dd");
			 d.setText(f1.format(dd));
			 DateFormat f2= new SimpleDateFormat("MM");
			 m.setText(f2.format(dd));
			 DateFormat f3= new SimpleDateFormat("yyyy");
			 y.setText(f3.format(dd)); 

			  txtdno.setText("");
			  txtbno.setText("");
			  //txtbdlast.setText("");
			   _d.setText("");
	           _m.setText("");
	           _y.setText("");
    
			  txtbdelapse.setText("");
			  txtbdage.setText("");
			  txtbdunit.setText("1");
		   }
								
			catch(Exception ee)
			{
			}
		
		}
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
			  ResultSet  res;
			  Statement st=con.createStatement();
			  
			  res=st.executeQuery("Select * from donationtbl");
			  String str="insert into donationtbl(bddate,dno,bno,bdlast,bdelapse,bdage,bdunit)values(?,?,?,?,?,?,?)";
			  PreparedStatement ps=con.prepareStatement(str);
			  ps.setInt(2,Integer.parseInt(txtdno.getText()));
			  ps.setString(3,txtbno.getText());
			  //ps.setString(4,txtbdlast.getText());
			  ps.setString(5,txtbdelapse.getText());
			  ps.setString(6,txtbdage.getText());
			  ps.setString(7,txtbdunit.getText());
              String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
	          ps.setString(1,tdate);
              String _tdate=_d.getText()+"/"+_m.getText()+"/"+_y.getText();
	          ps.setString(4,_tdate);  
			  int bdage=Integer.parseInt(txtbdage.getText());
			  int bdelapse=Integer.parseInt(days);
			  
			  String str1="update donortbl set dlast='"+tdate+"' where dno="+txtdno.getText();
              PreparedStatement ps1=con.prepareStatement(str1);

  if((flg==1)&&(_flg==1)&&(bdage>=18)&&(bdage<=65)&&(bdelapse>90))
	  {
		  ps1.executeUpdate();
		  ps.executeUpdate();
          JOptionPane.showMessageDialog(null,"saved succesfully");
	  }
	  else
	  {
		  if(flg!=1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid Date!");
		  }
		  if(_flg!=1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid Date Of Last Donation!");
		  }
		  if(bdage<18)
		  {
			  JOptionPane.showMessageDialog(null,"Not Eligible!! Age < 18 years");
		  }
		  if(bdage>65)
		  {
			  JOptionPane.showMessageDialog(null,"Not Eligible!! Age > 65years");
		  }
		  if(bdelapse<=90)
		  {
			  JOptionPane.showMessageDialog(null,"Not Eligible!! Time Elapse is <=90days");
		  }
	  }
			}
			catch(Exception eee)
			{
			}
		}
if(e.getSource()==bsearch)
    {
	try
	{
		int flag=0;
		Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from donationtbl where bno='"+txtbno.getText()+"'");
		while(res.next())
		{
		   String date=res.getString("bdate");
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

           String _date=res.getString("bdlast");
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
		  		   
		   txtdno.setText(String.valueOf(res.getInt("dno")));
		   txtbno.setText(res.getString("bno"));
		  // txtbdlast.setText(res.getString("bdlast"));
		   txtbdelapse.setText(res.getString("bdelapse"));
		   txtbdage.setText(res.getString("bdage"));
		   txtbdunit.setText(res.getString("bdunit"));
		   flag=1;
		}
		if(flag==0)
		JOptionPane.showMessageDialog(null,"No such Data");
	}
 	catch(Exception eeee)
	{
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
      String str="update donationtbl set bddate='"+tdate+"',dno='"+txtdno.getText()+"',bdlast='"+_tdate+"',bdelapse='"+txtbdelapse.getText()+"',bdage='"+txtbdage.getText()+"',bdunit='"+txtbdunit.getText()+"'where bno='"+txtbno.getText()+"'";
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
			JOptionPane.showMessageDialog(null,"Invalid Date Of Last Donation!");
		  }

           }
            }
catch(Exception eea)
{
}
}

if(e.getSource()==bdelete)
{
	try
{
	
	        Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from donationtbl where bno='"+txtbno.getText()+"'");
		if(res.next())
{
		String str="delete from donationtbl where bno='"+txtbno.getText()+"'";
                PreparedStatement ps=con.prepareStatement(str);
		ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
}
		else
	        JOptionPane.showMessageDialog(null,"No such Employee No.");
}
	catch(Exception ee)
{
	    
}

}
if(e.getSource()==brefresh)
{
	try
	{
		String bddate="",bddob="",_date="";
		int d1,d2,a,i;
		Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from donortbl where dno="+Integer.parseInt(txtdno.getText()));
		while(res.next())
		{
			bddob=res.getString("ddob");
			_date=res.getString("dlast");
		}
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
		
		i=bddob.lastIndexOf('/');
		bddob=bddob.substring((i+1));
		 bddate=y.getText();
		 d1=Integer.parseInt(bddate);
		 d2=Integer.parseInt(bddob);
		 a=d1-d2;
		 String age=a+"";
		 txtbdage.setText(age);
		 //System.out.println(age);		 
		 String datestop=d.getText()+"/"+m.getText()+"/"+y.getText();
		 String datestart=_date;
		 SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
		 Date dd1=null;
		 Date dd2=null;
		 dd1=f.parse(datestart);
		 dd2=f.parse(datestop);
		 long diff=dd2.getTime()-dd1.getTime();
		 long diffDays=diff/(24*60*60*1000);
		 days=diffDays+"";
		 txtbdelapse.setText(days+"days");
		 
		 
	}
	catch(Exception ee)
	{
		System.out.println(ee);
	}

}
if(e.getSource()==bbloodform)
{
	new Blood();
	//xyz obj=new xyz();
	//txtbno.setText(obj.send());
	/*try{
	String buno="";
	Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
	Statement st=con.createStatement();
	System.out.println("Hello");
	ResultSet res=st.executeQuery("select * from bloodtbl");
	while(res.next())
	{
		buno=res.getString("bno");
	}*/
	
	/*catch(Exception ieee)
	{
		System.out.println(ieee);
	}*/
}
if(e.getSource()==bnewdonor)
		{
			new Donor();
		}
}

public static int check_Date(int dd, int mm, int yy)
{
	int flg=0;
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
	  return(flg);
}
}

