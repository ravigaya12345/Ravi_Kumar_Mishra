import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class AddStudentUI extends JFrame implements ActionListener
{

JLabel lblName,lblFatherName,lblRollNo,lblRegistrationNo,lblDateOfBirth,
lblContact,lblEmail,lblGender,lblAddress,lblbtnNme,lblBranch;
JTextField txtName,txtFatherName,txtRollNo,txtRegistrationNo,txtDateOfBirth,txtContact,txtEmail,txtBranch;
JTextArea  txtAddress;
JRadioButton male,female,Addnew,Getinfo;
JButton btn,btnreset,btndelete,btnupdate;
JScrollPane pane;
public AddStudentUI()
{
  super("STUDENT PROFILE");
  ButtonGroup bg=new ButtonGroup();
  ButtonGroup bg1=new ButtonGroup();
  btn=new JButton("submit");
  btndelete=new JButton("Delete");
  btnupdate=new JButton("update");
  btnreset=new JButton("Reset");
  btndelete.addActionListener(this);
  btnupdate.addActionListener(this);
  btn.addActionListener(this);

  lblName=new JLabel("Name");
  lblFatherName=new JLabel("Father Name");
  lblGender=new JLabel("Gender");
  lblRollNo=new JLabel("RollNo");
  lblAddress=new JLabel("Address");
  lblRegistrationNo=new JLabel("Registration No.");
  lblDateOfBirth=new JLabel("D.O.B");
  lblContact=new JLabel("Contact No.");
  lblEmail=new JLabel("E-mail");
  lblGender=new JLabel("Gender");
  lblBranch=new JLabel("Branch");

  male=new JRadioButton("male",true);
  female=new JRadioButton("female");
  Addnew=new JRadioButton("Addnew",true);
  Getinfo=new JRadioButton("Getinfo");

  txtName=new JTextField();
  txtFatherName=new JTextField();
  txtRollNo=new JTextField();
  txtRegistrationNo=new JTextField();
  txtDateOfBirth=new JTextField();
  txtContact=new JTextField();
  txtEmail=new JTextField();
  txtBranch=new JTextField();
  txtAddress=new JTextArea();
  pane=new JScrollPane(txtAddress);
lblName.setBounds(50,90,150,30);
lblFatherName.setBounds(50,130,150,30);
lblGender.setBounds(50,170,150,30);
lblRollNo.setBounds(50,210,150,30);
lblBranch.setBounds(50,250,150,30);
lblAddress.setBounds(50,290,150,30);
lblRegistrationNo.setBounds(50,50,150,30);
lblDateOfBirth.setBounds(50,330,150,30);
lblContact.setBounds(50,370,150,30);
lblEmail.setBounds(50,410,150,30);


txtName.setBounds(190,90,150,30);
txtFatherName.setBounds(190,130,150,30);
txtRollNo.setBounds(190,210,150,30);
txtBranch.setBounds(190,250,150,30);
pane.setBounds(190,290,150,30);
txtRegistrationNo.setBounds(190,50,150,30);
txtRegistrationNo.setEnabled(false);
txtDateOfBirth.setBounds(190,330,150,30);
txtContact.setBounds(190,370,150,30);
txtEmail.setBounds(190,410,150,30);

btn.setBounds(100,470,100,30);
btnreset.setBounds(210,470,100,30);
btndelete.setBounds(330,470,100,30);
btnupdate.setBounds(450,470,100,30);
btn.addActionListener(this);
btnreset.addActionListener(this);
txtRegistrationNo.addActionListener(this);
male.setBounds(190,170,60,30);
female.setBounds(270,170,70,30);
Addnew.setBounds(170,10,120,30);
Getinfo.setBounds(330,10,120,30);
Addnew.addActionListener(this);
Getinfo.addActionListener(this);

add(lblName);
add(lblFatherName);
add(lblGender);
add(lblRollNo);
add(lblBranch);
add(lblRegistrationNo);
add(lblDateOfBirth);
add(lblContact);
add(lblEmail);
add(lblAddress);

add(btn);
add(btnreset);
add(btndelete);
add(btnupdate);
add(txtName);
add(txtFatherName);
add(txtRollNo);
add(txtBranch);
add(txtRegistrationNo);
add(txtDateOfBirth);
add(txtContact);
add(txtEmail);
add(pane);

add(male);
add(female);
bg.add(male);
bg.add(female);
add(Addnew);
add(Getinfo);
bg1.add(Addnew);
bg1.add(Getinfo);

setLayout(null);
setVisible(true);
setTitle("Student Form");
pack();
}

public void actionPerformed(ActionEvent e)
{
 if(e.getSource()==btn)
 {
  Student stud=new Student();
  stud.setName(txtName.getText());
  stud.setFname(txtFatherName.getText());
  stud.setRoll(Integer.parseInt(txtRollNo.getText()));
  stud.setGender(male.isSelected()?"Male":"Female");
  stud.setBranch(txtBranch.getText());
  stud.setRegistration(Long.parseLong(txtRegistrationNo.getText()));
  stud.setDob(txtDateOfBirth.getText());
  stud.setMobile(Long.parseLong(txtContact.getText()));
  stud.setEmail(txtEmail.getText());
  stud.setAddress(txtAddress.getText());
 if(StudentDA.add(stud))
{
   JOptionPane.showMessageDialog(null,"Your data entered successfully..!! Your reg. no. is "+StudentDA.fetchRegistration(StudentValues.stu));
;
} 
 else
   JOptionPane.showMessageDialog(null,"plz try again..!!");
}
//----------reset button------
if(e.getSource()==btnreset)
 {
  
  txtName.setText("");
  txtFatherName.setText("");
  txtRollNo.setText("");
  txtBranch.setText(""); 
  txtRegistrationNo.setText("");
  txtDateOfBirth.setText("");
  txtContact.setText("");
  txtEmail.setText("");
  txtAddress.setText("");
}
if(e.getSource()==txtRegistrationNo)
{
Student stud=StudentDA.getStudentByRegistration(Long.valueOf(txtRegistrationNo.getText()));
txtName.setText(stud.getName());
txtFatherName.setText(stud.getFname());
txtRollNo.setText(String.valueOf(stud.getRoll()));
txtBranch.setText(stud.getBranch());
txtRegistrationNo.setText(String.valueOf(stud.getRegistration()));
txtDateOfBirth.setText(stud.getDob());
txtContact.setText(String.valueOf(stud.getMobile()));
txtEmail.setText(stud.getEmail());
  txtAddress.setText(stud.getAddress());



}
if(e.getSource()==btndelete)
{
long x=Long.valueOf(txtRegistrationNo.getText());
boolean bb=StudentDA.delete(x);
System.out.println(bb);
}


 if(e.getSource()==btnupdate)

  {
  Student stud=new Student();
  stud.setName(txtName.getText());
  stud.setFname(txtFatherName.getText());
  stud.setRoll(Integer.parseInt(txtRollNo.getText()));
  stud.setGender(male.isSelected()?"Male":"Female");
  stud.setBranch(txtBranch.getText());
  stud.setRegistration(Long.parseLong(txtRegistrationNo.getText()));
  stud.setDob(txtDateOfBirth.getText());
  stud.setMobile(Long.parseLong(txtContact.getText()));
  stud.setEmail(txtEmail.getText());
  stud.setAddress(txtAddress.getText());
 if(StudentDA.update(stud))
{
   JOptionPane.showMessageDialog(null,"updated successfully..!! ");
} 
 else
   JOptionPane.showMessageDialog(null,"plz try again..!!");
}

if(e.getSource()==Addnew)
{
txtRegistrationNo.setEnabled(false);
}
if(e.getSource()==Getinfo)
{
txtRegistrationNo.setEnabled(true );
}
}



public static void main(String args[]) throws Exception
{
  new AddStudentUI();
  
}
}