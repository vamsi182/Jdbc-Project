package EmpDriver;

import java.util.Scanner;

import EmpService.EmpService;

public class EmpDriver {
	public static void main(String[] args) {
		System.out.println("WELCOME TO EMPLOYE MANAGEMENT APPLICATION");

		System.out.println("MENU DETAILS:");

		System.out.println("Press 1 to register employee");
        System.out.println("press 2 to update employe");
        System.out.println("press 3 to delete employe");
        System.out.println("press 4 to fetch all employe data");
        System.out.println("press 5 to close the application");
       Scanner sc= new Scanner(System.in);
        System.out.println("enter your choice");
        int choice=sc.nextInt();
       EmpService e1=new EmpService();
        
        switch (choice) {
		case 1:
			int res=e1.save();
			if (res!=0) {
				System.out.println("data saved!!!");
			}
			else
			{
				System.out.println("data not saved");
			}
			break;
		case 2:
			int res1=e1.update();
			if(res1!=0) {
				System.out.println("date is update sucessfully");
			}
			else {
				System.out.println("data will not update");
			}
			break;
		case 3:
			int res2=e1.delete();
			if(res2!=0) {
				System.out.println("date is delete sucessfully");
			}
			else {
				System.out.println("data will not delete");
			}
			break;
		
		case 4:
			e1.fetchall();
			System.out.println("fetch all the record ");
			break;
		case 5:
			 
		   sc.close();
		   System.out.println("exit the application");
		   break;
		default:
			System.out.println("given number is invalid enter the valid number");
			break;
		}
        
	}
}
