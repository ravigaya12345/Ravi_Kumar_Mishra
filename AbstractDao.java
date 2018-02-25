import java.sql.*;
public abstract class AbstractDao {
public static Connection getConnection()
{
Connection con=null;
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System1","9934687065");

}catch(Exception e)
{
System.out.println(e);	
}
return con;
}
}
