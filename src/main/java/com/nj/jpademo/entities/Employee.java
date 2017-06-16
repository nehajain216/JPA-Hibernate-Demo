package com.nj.jpademo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
//@Table(name="employee")
@NamedQuery(query="select e from Employee e where e.id=:id", name="Employee_Id")
public class Employee {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private float salary;
	
	/* @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="lotid")
	private ParkingSpace parkingSpace; */
	
	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="empid", referencedColumnName="id", nullable=false)
	//List<Address> address;

	/*public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}*/

	public Employee() {
	}
	
	public Employee(int id) 
	{
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	

	/* public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	} */

}
