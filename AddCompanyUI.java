import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class AddCompanyUI extends JFrame implements ActionListener
{

 JLabel lblCode,lblName,lblEstablishmentYear,lblType;
 JTextField txtCode,txtName,txtEstablishmentYear,txtType;
 JRadioButton CreateNew,FetchDetail;
 JButton btnadd,btnreset,btndelete,btnupdate;

 public AddCompanyUI()
{
 super("COMPANY PROFILE");
 
 ButtonGroup bg=new ButtonGroup(); 
 CreateNew =new JRadioButton("CreateNew",true);
 FetchDetail=new JRadioButton("FetchDetail",false);
 CreateNew.setBounds(50,10,150,30);
 FetchDetail.setBounds(210,10,150,30);

 btnadd=new JButton("ADD");
 btnreset=new JButton("RESET");
 btndelete=new JButton("DELETE");
 btnupdate=new JButton("UPDATE");

 lblCode =new JLabel("Code");
 lblName= new JLabel("Name");
 lblEstablishmentYear=new JLabel("EstablishmentYear");
 lblType=new JLabel("Type");
 txtCode=new JTextField();
 txtName=new JTextField();
 txtEstablishmentYear=new JTextField();
 txtType=new JTextField();
 lblName.setBounds(50,50,70,20);
 lblCode.setBounds(50,90,70,20);
 lblEstablishmentYear.setBounds(50,130,170,20);
 lblType.setBounds(50,170,70,20);
 add(lblCode);
 this.add(lblName);
 this.add(lblEstablishmentYear);
 this.add(lblType);
 this.add(txtCode);
 this.add(txtName);
 this.add(txtEstablishmentYear);
 this.add(txtType);
 this.setVisible(true);
 txtName.setBounds(190,50,100,20);
 txtCode.setBounds(190,90,100,20);
 txtEstablishmentYear.setBounds(190,130,100,20);
 txtType.setBounds(190,170,100,20);

 btnadd.setBounds(50,210,80,30);
 btnreset.setBounds(150,210,80,30);
 btndelete.setBounds(250,210,80,30);
 btnupdate.setBounds(350,210,80,30);

 add(btnadd);
 add(btnreset);
 add(btndelete);
 add(btnupdate);
 add(CreateNew);
 add(FetchDetail);
 bg.add(CreateNew);
 bg.add(FetchDetail);
 btnadd.addActionListener(this);
 this.setLayout(null);
}
 public void actionPerformed(ActionEvent e)
{
 if(e.getSource()==btnadd)
try
{
  Company comp=new Company();
  comp.setCode(Integer.parseInt(txtCode.getText()));
  comp.setName(txtName.getText());
  comp.setType(txtType.getText());
  comp.setEstablishmentYear(Integer.parseInt(txtEstablishmentYear.getText()));
if(CompanyDA.add(comp))
{
   JOptionPane.showMessageDialog(null,"Your data entered successfully..!! Your company code is "+CompanyDA.fetchCode(CompanyValues.cmpy));

} 
 else
{
   JOptionPane.showMessageDialog(null,"plz try again..!!");
}


}
catch(Exception x) 
{
System.out.println(x);
}
 }

public static void main(String args[])
{
new AddCompanyUI();
}
}

