import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
public class Mnu extends JFrame implements ActionListener
{
MenuBar mnu=new MenuBar();
Menu m=new Menu("Master");
Menu t=new Menu("Transaction");
Menu r=new Menu("Report");
Menu ex=new Menu("Exit");

MenuItem mdonor=new MenuItem("Donor");
MenuItem mstaff=new MenuItem("Staff");
MenuItem mblood=new MenuItem("Blood");
MenuItem mpatient=new MenuItem("Patient");
MenuItem mcamp=new MenuItem("Camp");
//MenuItem tcollect=new MenuItem("Blood Collection");
MenuItem tissue=new MenuItem("Blood Issue");
MenuItem tbill=new MenuItem("Billing");
MenuItem tdbc=new MenuItem("Donation By Camp");
MenuItem tdonation=new MenuItem("Blood Donation");
MenuItem rdonor=new MenuItem("Donor Report");
MenuItem rstaff=new MenuItem("Staff Report");
MenuItem rblood=new MenuItem("Blood Stock Report");
MenuItem rcash=new MenuItem("Cash Collection Report");
MenuItem rcamp=new MenuItem("Camp Report");
MenuItem exexit=new MenuItem("Exit");
JLabel Bground=new JLabel(new ImageIcon("pic.png"));
public static void main(String args[])throws IOException
{
Mnu ob=new Mnu();
}
public Mnu()
{
setLayout(null);
setVisible(true);
setSize(2000,2000);
mnu.add(m);
mnu.add(t);
mnu.add(r);
mnu.add(ex);
m.add(mdonor);
m.add(mstaff);
m.add(mblood);
m.add(mpatient);
m.add(mcamp);
//t.add(tcollect);
t.add(tbill);
t.add(tdbc);
t.add(tdonation);
t.add(tissue);
r.add(rdonor);
r.add(rstaff);
r.add(rblood);
r.add(rcash);
r.add(rcamp);
ex.add(exexit);
setMenuBar(mnu);
Bground.setBounds(0,0,1350,770);
exexit.addActionListener(this);
mblood.addActionListener(this);
mstaff.addActionListener(this);
mdonor.addActionListener(this);
mpatient.addActionListener(this);
mcamp.addActionListener(this);
rdonor.addActionListener(this);
rstaff.addActionListener(this);
rblood.addActionListener(this);
rcash.addActionListener(this);
rcamp.addActionListener(this);
tbill.addActionListener(this);
tdbc.addActionListener(this);
tdonation.addActionListener(this);
tissue.addActionListener(this);

//tcollect.addActionListener(this);
add(Bground);

}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==exexit)
{
this.dispose();
}
if(e.getSource()==mdonor)
{
  new Donor();
}
if(e.getSource()==mstaff)
{
  new Staff();
}
if(e.getSource()==mblood)
{
  new Blood();
}
if(e.getSource()==mpatient)
{
  new Patient();
}
if(e.getSource()==mcamp)
{
  new Camp();
}
/*if(e.getSource()==tcollect)
{
  new Bloodcollection();
}*/
if(e.getSource()==tbill)
{
  new Bill();
}
if(e.getSource()==tdbc)
{
  new DBC();
}
if(e.getSource()==tdonation)
{
  new Donation();
}
if(e.getSource()==tissue)
{
  new Bloodissue();
}
if(e.getSource()==rdonor)
{
	new Donorreport();
}
if(e.getSource()==rcamp)
{
	new Campreport();
}
if(e.getSource()==rblood)
{
	new Bloodstockreport();
}
if(e.getSource()==rcash)
{
	new Cashcollectreport();
}
if(e.getSource()==rstaff)
{
	new Staffreport();
}

}
}