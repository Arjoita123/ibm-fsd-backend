package com.examples.java.jdbc;

import java.util.Scanner;

public class EmpService {
	private int k;
	int i;
	int a;
	String n;
	String c;
	String d;
	



	public void process(int k) throws Exception {
		this.k=k;
		if(k==1) {
			
//			Employee emp=new Employee();
//			System.out.println("Enter id");
//			Scanner sc1=new Scanner(System.in);
//			 i=sc1.nextInt();
//			
//
//			System.out.println("Enter age");
//			Scanner sc2=new Scanner(System.in);
//			 a=sc2.nextInt();
//			
//			System.out.println("Enter name");
//			Scanner sc3=new Scanner(System.in);
//			 n=sc3.next();
//			
//			System.out.println("Enter department");
//			Scanner sc4=new Scanner(System.in);
//			 d=sc4.next();
//			
//			System.out.println("Enter country");
//			Scanner sc5=new Scanner(System.in);
//			 c=sc5.next();
//			emp.setAge(a);
//			emp.setEmpId(i);
//			emp.setDept(d);
//			emp.setName(n);
//			emp.setCountry(c);
			EmpData e=new EmpData();
			
			e.display();
			
		}
		if(k==2) {
	EmpData e=new EmpData();
			
			e.veiw();// TODO Auto-generated method stub
		}
		
		if(k==3) {
EmpData e=new EmpData();
			
			e.update();
		}
		
		if(k==4) {
EmpData e=new EmpData();
			
			e.delete();
		}
		
		if(k==5) {
			EmpData e=new EmpData();
					
					e.veiwAll();// TODO Auto-generated method stub
				}
		
	}

}
