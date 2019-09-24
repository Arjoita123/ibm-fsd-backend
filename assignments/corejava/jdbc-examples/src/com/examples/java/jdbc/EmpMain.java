package com.examples.java.jdbc;

import java.util.Scanner;

public class EmpMain {
     public static void main(String[] args) throws Exception {
    	
    	 System.out.println("Enter operation to be performed");
 		System.out.println("1:add employee");
 		System.out.println("2:veiw employee");
 		System.out.println("3:update employee");
 		System.out.println("4:delete employee");
 		System.out.println("5:VEIWALL employee");
 		
 		
 		
			Scanner sc=new Scanner(System.in);
 			int k=sc.nextInt();
 			EmpService es=new EmpService();
 			es.process(k);
     }
	
}
