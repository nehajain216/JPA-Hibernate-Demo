/**
 * 
 */
package com.nj.jpademo;

import java.util.Arrays;
import java.util.List;

import com.nj.jpademo.dao.EmployeeDAO;
import com.nj.jpademo.entities.Address;
import com.nj.jpademo.entities.Category;
import com.nj.jpademo.entities.Company;
import com.nj.jpademo.entities.Employee;
import com.nj.jpademo.entities.ParkingSpace;
import com.nj.jpademo.entities.Person;
import com.nj.jpademo.entities.Stock;
import com.nj.jpademo.utils.PersistenceManager;

/**
 * @author Siva
 *
 */
public class Main {

	static EmployeeDAO dao = new EmployeeDAO();
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//saveEmployee();
		//findEmployee(6);
		//deleteEmployee(6);
		//updateEmployee();
		//allEmployees();		
		//savePerson();
		//saveStock();
		//saveCategory();
		
		//displayMaxSalary();
		//displaySalaryBetween();
		findEmployee();
		PersistenceManager.close();
	}
	
	static void displayMaxSalary()
	{
		float maxSalary = dao.maxSalary();
		System.out.println("Emp Max Salary:"+maxSalary);
	}
	
	static void findEmployee()
	{
		// based on named query
		int id = 5;
		Employee e = dao.findEmployee(id);
		System.out.println(e.toString());
	}
	
	static void displaySalaryBetween()
	{
		float lowerRange = 10000;
		float upperRange = 100000;
		List<Employee> list = dao.salaryBetween(lowerRange, upperRange);
		for(Employee e: list)
		{
			System.out.println(e.toString());
		}
	}
	
	static void saveStock()
	{
		Stock stock=new Stock();
		stock.setScode("1111");
		stock.setSname("Brand W");
		
		Category c1=new Category();
		c1.setCname("Patiyalas");
		c1.setCdescription("cotton");

		Category c2=new Category();
		c2.setCname("capris");
		c2.setCdescription("designers");
		
		stock.setCategories(Arrays.asList(c1,c2));
		dao.saveStock(stock);
	}
	
	static void saveCategory()
	{
		Category c = new Category();
		c.setCname("Sarees");
		c.setCdescription("cotton");
		
		Stock s1=new Stock();
		s1.setScode("1234");
		s1.setSname("LifeStyle");
		
		Stock s2=new Stock();
		s2.setScode("9876");
		s2.setSname("Central");
		c.setStock(Arrays.asList(s1,s2));
		
		dao.saveCategory(c);
		
	}
	static void savePerson()
	{
		Company c = new Company("Sivalabs","Gachibowli");
		//dao.save(c);
		Person p = new Person();
		p.setName("siva");
		p.setCompany(c);
		Person p1= new Person();
		p1.setName("Neha");
		p1.setCompany(c);
		c.setPerson(Arrays.asList(p,p1));
		dao.save(c);
	}

	/*static void saveEmployee()
	{
		Employee e = new Employee();
		//e.setId(1);
		e.setName("Prasad Reddy");
		e.setSalary(180000);
		
		ParkingSpace ps = new ParkingSpace();
		ps.setLot(11);
		ps.setLocation("kanpur");
		e.setParkingSpace(ps);
		
		Address a= new Address();
		a.setAddress("secunderabad");
		Address a1= new Address();
		a1.setAddress("balanagar");
		//e.setAddress(Arrays.asList(a,a1));
		//dao.save(e);
	}*/
	
	static void findEmployee(int id)
	{
		Employee e = dao.find(id);
		if(e != null)
		System.out.println("Employee Id:"+e.getId()+"\nEmployee Name:"+e.getName()+"\nEmployee Salary:"+e.getSalary());
		else
			System.out.println("No record found");
	}
	
	static void deleteEmployee(int id)
	{
			dao.delete(id);		
	}
	static void updateEmployee()
	{
		dao.update(1, 100000);
	}
	static void allEmployees()
	{
		List<Employee>  empList = dao.listAllEmployee();
		for(Employee e : empList)
		{
			System.out.println("Employee Id:"+e.getId()+"\nEmployee Name:"+e.getName()+"\nEmployee Salary:"+e.getSalary());
		}
	}
}
