import java.sql.*;
class CompanyDA extends AbstractDao
{
static Connection cc=getConnection();
//----method to add a student---
public static boolean  add(Company company)
{
try
{
PreparedStatement stat=cc.prepareStatement("insert into company (code,name,Establishment_year,type) values (?,?,?,?)");
stat.setInt(1,company.getCode());
stat.setString(2,company.getName());
stat.setInt(3,company.getEstablishmentYear());
stat.setString(4,company.getType());
stat.executeUpdate();
CompanyValues.cmpy=company;
return true;
}
catch(Exception e){System.out.println(e);
return false;
}
}
//----fetch code. of  student---
public static int fetchCode(Company company)
{
int code=-1;
try
{
PreparedStatement stat=cc.prepareStatement("select code from company where name=? and type=?");
stat.setString(1,company.getName());
stat.setString(2,company.getType());
ResultSet rs=stat.executeQuery();
while(rs.next())
{
//System.out.println(rs.getInt(1));
code=rs.getInt(1);
}

return code;
}
catch(Exception e){System.out.println(e);
return code;
}
}

//----fetch student by code---
public static Company getCompanyCode(int code)
{
Company company=null;
try
{
PreparedStatement stat=cc.prepareStatement("select * from company where CODE="+code);
ResultSet rs=stat.executeQuery();
while(rs.next())
{
company=new Company();
company.setCode(rs.getInt(1));
company.setName(rs.getString(2));
company.setEstablishmentYear(rs.getInt(3));
company.setType(rs.getString(3));

}
return company;
}
catch(Exception e){System.out.println(e);
return company;
}
}

}