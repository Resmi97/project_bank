package jdbc;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class sbi1 {
	String sql;
	
	void create(Connection c, Statement s) throws SQLException
	{
		sql = "create table customer_details\r\n"
				+ "(\r\n"
				+ "cus_id int auto_increment primary key,\r\n"
				+ "cus_name varchar(50) not null,\r\n"
				+ "cus_age int not null\r\n"
				+ ");";
		s.executeUpdate(sql);
		System.out.println("table Created .....");
	}	
	
	void DetailsEntry(Connection c, Statement s) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter customer name: ");
		String name=sc.next();
		System.out.println("Enter customer age: ");
		int age=sc.nextInt();
		while (age<18) {
			System.out.println("Age cannot be less than 18...Please enter valid details...");
			System.out.println("Enter customer name: ");
			name=sc.next();
			System.out.println("Enter customer age: ");
			age=sc.nextInt();
		}
		sql = "insert into customer_details  (cus_name, cus_age) values ( '"+ name +"','"+ age +"')";
		s.executeUpdate(sql);
		System.out.println("Customer details are added successfully!!\n");
		System.out.println("Displaying the details of the new customer ");
		sbi1 bankMethods = new sbi1();
		bankMethods.display(c, s, name, age);
	}
	
	void display(Connection c1, Statement s1, String name, int age) throws SQLException
	{
		sql = "Select * from customer_details where cus_name='"+ name +"' && cus_age='"+ age +"'";
		ResultSet rs=s1.executeQuery(sql);
		while(rs.next())
			System.out.println("Customer_ID = "+rs.getInt(1)+" \nCustomer_Name = "+rs.getString(2)+" \nCustomer_Age = "+rs.getString(3)+"\n");
	}
}