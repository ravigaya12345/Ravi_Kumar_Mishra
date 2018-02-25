import java.sql.*;
class StudentDA extends AbstractDao
{
static Connection cc=getConnection();
//----method to add a student---
public static boolean  add(Student student)
{
try
{
PreparedStatement stat=cc.prepareStatement("insert into student (name,father_name,registration,roll_no,dob,address,contact,email,branch,gender) values (?,?,?,?,?,?,?,?,?,?)");
stat.setString(1,student.getName());
stat.setString(2,student.getFname());
stat.setLong(3,student.getRegistration());
stat.setInt(4,student.getRoll());
stat.setString(5,student.getDob());
stat.setString(6,student.getAddress());
stat.setLong(7,student.getMobile());
stat.setString(8,student.getEmail());
stat.setString(9,student.getBranch());
stat.setString(10,student.getGender());
stat.executeUpdate();
StudentValues.stu=student;
return true;
}
catch(Exception e){System.out.println(e);
return false;
}
}

//----fetch reg. of  student---
public static long fetchRegistration(Student student)
{
long reg=-1;
try
{
PreparedStatement stat=cc.prepareStatement("select registration from student where roll_no=? and contact=?");
stat.setInt(1,student.getRoll());
stat.setLong(2,student.getMobile());
ResultSet rs=stat.executeQuery();
while(rs.next())
{
//System.out.println(rs.getLong(1));
reg=rs.getLong(1);
}
return reg;
}
catch(Exception e){System.out.println(e);
return reg;
}
}

//----fetch student by registration---
public static Student getStudentByRegistration(long reg)
{
Student student=null;
try
{
PreparedStatement stat=cc.prepareStatement("select * from student where REGISTRATION="+reg);
ResultSet rs=stat.executeQuery();
while(rs.next())
{
student=new Student();
student.setName(rs.getString(1));
student.setFname(rs.getString(2));
student.setRegistration(rs.getLong(5));
student.setRoll(rs.getInt(3));
student.setDob(rs.getString(6));
student.setAddress(rs.getString(7));
student.setMobile(rs.getLong(8));
student.setEmail(rs.getString(9));
student.setBranch(rs.getString(10));
student.setGender(rs.getString(4));
}
return student;
}
catch(Exception e){System.out.println(e);
return student;
}
}
public static boolean delete(long reg)
{
 try
{
PreparedStatement stat=cc.prepareStatement("delete from student where REGISTRATION="+reg);
stat.executeUpdate();
return true;
}
catch(Exception e)
{
 return false;
}
}
public static boolean update(Student student)
{
try
{
PreparedStatement stat=cc.prepareStatement("update student set name=?,roll_no=? where REGISTRATION=?");
stat.setString(1,student.getName());
stat.setInt(2,student.getRoll());
stat.setLong(3,student.getRegistration());
stat.executeQuery();
return true;
}
 catch(Exception e)
{
 return false;
}
}
}