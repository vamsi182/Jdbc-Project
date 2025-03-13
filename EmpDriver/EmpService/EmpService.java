
package EmpService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpService {
	private static Scanner sc=new Scanner(System.in);
	private static String url="jdbc:postgresql://localhost:5432/empmanagement?user=postgres&password=123";
	private static Connection con;
	static {
		
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int save()
	{
		int res=0;
		System.out.println("enter the employe id:");
		int id=sc.nextInt();
		System.out.println("enter employe name:");
		String name=sc.next();
		System.out.println("enter employe age");
		int age=sc.nextInt();
		System.out.println("enter the slaray of emoplye");
		int salary=sc.nextInt();
		
		String sql="INSERT into emp values(?,?,?,?)";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
            pstm.setInt(3, age);
            pstm.setInt(4, salary);

           res= pstm.executeUpdate();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public int update()
	{
		int res=0;
		System.out.println("enter employe update id");
		int id=sc.nextInt();
		System.out.println("enter the employe age:");
		int age=sc.nextInt();
		System.out.println("enter the employe salary:");
		int salary=sc.nextInt();
		
		String sql="Update emp set age=?,salary=? where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, age);
            pstm.setInt(2, salary);
            pstm.setInt(3, id);
            

           res= pstm.executeUpdate();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public int delete()
	{
		int res=0;
		System.out.println("enter the employe id:");
		int id=sc.nextInt();
		
		String sql="delete from emp where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
		
            pstm.setInt(1, id);
            

           res= pstm.executeUpdate();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public int fetchall() {
		int res1=0;
		String sql="select * from emp";
		try {
			Statement stm=con.createStatement();
			System.out.println(stm);
			ResultSet res=stm.executeQuery(sql);
			while(res.next()) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getInt(3));
				System.out.println(res.getInt(4));
            System.out.println("==============");
		}
		}
			catch (SQLException e) {
			e.printStackTrace();
		}
		return res1;
		
		
		}
}



