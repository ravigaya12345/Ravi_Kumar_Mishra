import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class OptionStudent extends JFrame implements ActionListener
{
JButton btn,btn1;
public OptionStudent()
{
super("Option");
btn=new JButton("Create New");
btn1=new JButton("Get Info");

btn.setBounds(400,200,200,30);
btn1.setBounds(800,200,200,30);

add(btn);
add(btn1);



setLayout(null);
setVisible(true);
btn.addActionListener(this);
btn1.addActionListener(this);
pack();
}
public void actionPerformed(ActionEvent job)
{
 if (job.getSource()==btn)
{
 AddStudentUI add=new AddStudentUI();
}
else if(job.getSource()==btn1)
{
GetStudentUI get =new GetStudentUI();
}
}

public static void main(String args[])
{
new OptionStudent();
}
}