package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert 
{
	public static void main(String[] args) 
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Sanju","root","root");
		PreparedStatement ps=con.prepareStatement("insert into Emp values(?,?,?)");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name salary of employee");
		String n=br.readLine();
		float f=Float.parseFloat(br.readLine());
		ps.setString(1, null);
		ps.setString(2, n);
		ps.setFloat(3, f);
		int result=ps.executeUpdate();
		if(result==1)
		 System.out.println("Record Inserted");
		else
			System.out.println("try again");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
