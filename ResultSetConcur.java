package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class ResultSetConcur 
{
	public static void main(String[] args) 
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Sanju","root","root");
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=stmt.executeQuery("select * from Emp");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name to delete Record");
		String n=br.readLine();
		while(rs.next())
		{
			if(rs.getString("name").equalsIgnoreCase(n))
			{
				rs.deleteRow();
			}
			else
			{
				System.out.println(rs.getString("id")+"\t"+rs.getString("name")+rs.getFloat("salary"));
			}
		}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
	}

}
