package jdbc;




import java.sql.*;
import java.util.Scanner;
public class sbi2 extends sbi1 {
	private static Object outerloop;

	public static int printOptions(){
		System.out.println("********WELCOME TO SBI BANK SERVICES********");
		System.out.println("Please select your choice!!");
		System.out.println("\t1 - Create New Account");
		System.out.println("\t2 - Quit");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		return i;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sbi","root","root");
		Statement s=c.createStatement();
		sbi2 obj=new sbi2();
		obj.create(c, s);
		int choice;
	outerloop:
		while(true) {
			choice=printOptions();
			switch(choice) {
			case 1:
				obj.DetailsEntry(c, s);
				break;
			case 2:
				System.out.println("Thank you for using our service...");
				break outerloop;
			
			}
		}
	}
}