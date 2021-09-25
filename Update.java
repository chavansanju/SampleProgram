package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name and update salary of employee");
			String n=br.readLine();
			float sal=Float.parseFloat(br.readLine());
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Sanju","root","root");
			Statement stmt=con.createStatement();
			int result=stmt.executeUpdate("update Emp set salary="+sal+" where name ='"+n+"' ");
					
					if(result>0)
					{
						System.out.println("updated");
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
		
		
	}
}
