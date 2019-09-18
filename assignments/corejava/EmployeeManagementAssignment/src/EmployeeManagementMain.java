import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementMain {
 public static void main(String []args) {
		List< EmployeeService> employee = new ArrayList< EmployeeService>();
		employee.add(new  EmployeeService(1,21,"Arjoita","engg.","INDIA"));
		employee.add(new  EmployeeService(11,21,"Arjo","engg.","INDIA"));
		System.out.println(employee);
		
		System.out.println("Enter operation to be performed");
		System.out.println("1:add employee");
		System.out.println("2:veiw employee");
		System.out.println("3:veiw all employee");
		System.out.println("4:update employee");
		System.out.println("5:delete employee");
		System.out.println("6:import");
		System.out.println("7:export");
		
		for(int x=0;x<10;x++) {
			Scanner sc=new Scanner(System.in);
			int k=sc.nextInt();
		if(k==1) {
			System.out.println("Enter id");
			Scanner sc1=new Scanner(System.in);
			int i=sc1.nextInt();
			

			System.out.println("Enter age");
			Scanner sc2=new Scanner(System.in);
			int a=sc2.nextInt();
			
			System.out.println("Enter name");
			Scanner sc3=new Scanner(System.in);
			String n=sc3.next();
			
			System.out.println("Enter department");
			Scanner sc4=new Scanner(System.in);
			String d=sc4.next();
			
			System.out.println("Enter country");
			Scanner sc5=new Scanner(System.in);
			String c=sc5.next();
//			for(int j=0;j<employee.size();j++) {
//				if(employee.get(j).empId==i) {
//					System.out.println(employee.get(j));
//					break;
//				}
//				else {
//					employee.add(new  EmployeeService(i,a,n,d,c));
//				}
//			}
			employee.add(new  EmployeeService(i,a,n,d,c));
			
//			 try{
//	                FileOutputStream fos= new FileOutputStream("C:\\Users\\ArjoitaBanerjee\\Desktop\\emp.txt");
//	                ObjectOutputStream oos= new ObjectOutputStream(fos);
//	                oos.writeObject(employee);
//	                oos.close();
//	                fos.close();
//	            }catch(IOException ioe){
//	                ioe.printStackTrace();
//	            }
			
			System.out.println("Enter next operation");
			
//			System.out.println(employee);
		}
		
		if(k==6) {
			try {
			FileInputStream fstream = new FileInputStream("C:\\Users\\ArjoitaBanerjee\\Desktop\\emp.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
				String[] data=strLine.split(",");
				employee.add(new EmployeeService(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2],data[3],data[4]));
				System.out.println(data[1]);
				
			}
			}
			catch(IOException ioe){
                ioe.printStackTrace();
            }
			
		}
		
		if(k==7) {
			
			 try{    
		           FileWriter fw=new FileWriter("C:\\Users\\ArjoitaBanerjee\\Desktop\\emp.txt");
		           for(int j=0;j<employee.size();j++) {
		        	   String s1=Integer.toString(employee.get(j).getEmpId());
		        	   String s2=Integer.toString(employee.get(j).getAge());
		        	   String s3=employee.get(j).getName();
		        	   String s4=employee.get(j).getDept();
		        	   String s5=employee.get(j).getCountry();
		        	   
		        	   String d=s1+","+s2+","+s3+","+s4+","+s5;
		        	   
		        	   fw.write(d);    
		           }
		           
		           
		           fw.close();    
		          }catch(Exception e){System.out.println(e);}    
		             
		     }  
		
		
		
		
		
		
		
		
		if(k==0) {
			System.out.println(employee);
			break;
		}
		if(k==2) {
			System.out.println("Enter id");
			Scanner sc1=new Scanner(System.in);
			int i=sc1.nextInt();
			for(int j=0;j<employee.size();j++) {
				if(employee.get(j).empId==i)
				{
					System.out.println(employee.get(j));
					
					}
				}
			System.out.println("Enter next operation");
		}
		
		
		
		if(k==4) {
			
			System.out.println("Enter id");
			Scanner sc1=new Scanner(System.in);
			int i=sc1.nextInt();
			for(int j=0;j<employee.size();j++) {
				if(employee.get(j).empId==i)
				{
					
					
					employee.set(j, new  EmployeeService(101,21,"Arjo","engg.","INDIA") );
					System.out.println("updated");
					System.out.println(employee);
					
					}
			}
			System.out.println("Enter next operation");
			
		}
		if(k==3) {
			System.out.println("veiw all");
			System.out.println(employee);
			System.out.println("Enter next operation");
		}
		
		
		if(k==5) {
			System.out.println("Enter id");
			Scanner sc1=new Scanner(System.in);
			int i=sc1.nextInt();
			for(int j=0;j<employee.size();j++) {
				if(employee.get(j).empId==i)
				{
					
					
					employee.remove(j);
					System.out.println("updated");
					System.out.println(employee);
					
					}
			}
			System.out.println("Enter next operation");
		}
		x--;	
		}
		

		
	 
 }
}

class EmployeeService implements Serializable{
	int empId;
	int age;
	String name;
	String dept;
	String country;

	EmployeeService(int empId, int age,String name,	String dept,String country ) {
		this.empId = empId;
		this.age = age;
		this.name = name;
		this.dept=dept;
		this.country=country;

	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int a) {
		age = a;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String a) {
		name = a;
	}
	

	public String getDept() {
		return dept;
	}

	public void setDept(String a) {
		dept = a;
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String a) {
		country = a;
	}
	@Override
	public String toString() {
		return " Emloyee[id.=" + empId + "Age: "+age+"Name: "+name+"department: "+dept+"Country: "+country + "]";
	}
}
