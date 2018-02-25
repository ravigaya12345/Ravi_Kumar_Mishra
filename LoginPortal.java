import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class LoginPortal extends JFrame implements ActionListener
{
JButton btn,btn1;
public LoginPortal()
{
super("Login Portal");
btn=new JButton("Student Login");
btn1=new JButton("Company Login");

btn.setBounds(400,200,200,30);
btn1.setBounds(800,200,200,30);

add(btn);
add(btn1);



setLayout(null);
setVisible(true);
setTitle("Login Portal");


btn.addActionListener(this);
btn1.addActionListener(this);

pack();
}
public void actionPerformed(ActionEvent job)
{
if (job.getSource()==btn)
{
 this.dispose();
 OptionStudent opt=new OptionStudent();
}
else if(job.getSource()==btn1)
{
  AddCompanyUI cmp= new AddCompanyUI();
}
} 









public static void main(String args[])
{
new LoginPortal();
}
}