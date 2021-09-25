package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchPrcessingusingSmt 
{
	public static void main(String[] args) 
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Sanju","root","root");
		Statement stmt=con.createStatement();
		stmt.addBatch("insert into Emp values(null,'komal',4500)");
		stmt.addBatch("delete from Emp where id<=2");
		stmt.addBatch("Update Emp set salary=90000 where id=3");
		stmt.addBatch("insert into Emp values(null,'Suraj',5500)");
		int arr[]=stmt.executeBatch();
		System.out.println("Result:");
		for(int val:arr)
			System.out.println(val);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		
	}

}
