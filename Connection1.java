package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection1 
{
	public static void main(String[] args) 
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name salary of employee");
			String n=br.readLine();
			float sal=Float.parseFloat(br.readLine());
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Sanju","root","root");
			Statement stmt=con.createStatement();
			int result=stmt.executeUpdate("insert into Emp values(null,'"+n+"',"+sal+")");
					
					if(result==1)
					{
						System.out.println("Record Inserted");
					}
					else
					{
						System.out.println("Please try again");
					}
		}
		catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
}
