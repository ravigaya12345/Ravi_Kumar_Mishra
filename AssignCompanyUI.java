import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class AssignCompanyUI extends JFrame
{
 JComboBox cbsStudent,cbsCompany;
 JLabel lblName,lblRoll,lblCompanyName,lblCompanyType,lblComboStudent,lblComboCompany;
 JButton btnAdd;
 
public AssignCompanyUI()
{
 super("Assign Comapny");
 lblName =new JLabel("NAME");
lblRoll =new JLabel("ROLL");
lblCompanyName =new JLabel("NAME");
lblCompanyType =new JLabel("TYPE");
lblComboStudent =new JLabel("");
lblComboCompany =new JLabel("");



 btnAdd=new JButton("ADD");
  
 add(btnAdd);
 cbsStudent=new JComboBox();
 cbsCompany=new JComboBox();
 add(cbsStudent);
 add(cbsCompany);
 add(lblName);
 add(lblRoll);
 add(lblCompanyType);
 add(lblCompanyName);
btnAdd.setBounds(100,500,100,50);
cbsCompany.setBounds(100,50,50,50);
cbsStudent.setBounds(100,200,50,50);
lblName.setBounds(300,200,100,50);
lblRoll.setBounds(450,200,100,50);
lblCompanyName.setBounds(300,50,100,50);
lblCompanyType.setBounds(450,50,100,50);


setLayout(null);
setVisible(true);

pack(); 
}
 public static void main(String args[])
{
 new AssignCompanyUI();
}
}