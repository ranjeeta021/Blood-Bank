import java.awt.*;
import javax.swing.*;
import java.io.*;
public class SplashScreen extends JWindow 
{ 
  public SplashScreen()
  {
    JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.white);

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(500,220,550,250);

    // Build the splash screen
    JLabel label = new JLabel(new ImageIcon("Splashpic.png"));
    JLabel copyrt = new JLabel("Copyright by SARP", JLabel.CENTER);
    copyrt.setFont(new Font("Serif", Font.BOLD, 12));
    content.add(label, BorderLayout.CENTER);
    content.add(copyrt, BorderLayout.SOUTH);
    Color oraRed = new Color(156, 20, 20,  255);
    content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

    setVisible(true);

    try 
    {
      Thread.sleep(3000); 
       this.dispose();
       new Login();
    } 
    catch (Exception e) 
    {
	System.out.println(e);
    }


   
  }

  public static void main(String[] args) 
  {
    SplashScreen splash = new SplashScreen();
 
  }
}