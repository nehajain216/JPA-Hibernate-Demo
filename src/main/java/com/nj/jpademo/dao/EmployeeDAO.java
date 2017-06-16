package com.nj.jpademo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.nj.jpademo.entities.Category;
import com.nj.jpademo.entities.Company;
import com.nj.jpademo.entities.Employee;
import com.nj.jpademo.entities.Stock;
import com.nj.jpademo.utils.PersistenceManager;

public class EmployeeDAO {

	/* public void save(Employee e) {

		EntityManager em = PersistenceManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}*/
	
	public void saveStock(Stock s)
	{
		EntityManager em = PersistenceManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public void saveCategory(Category c)
	{
		EntityManager em = PersistenceManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public void save(Company c) {

		EntityManager em = PersistenceManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	public Employee find(int id) {
		EntityManager em = PersistenceManager.getEntityManager();
		return em.find(Employee.class, id);
	}

	public void delete(int id) {
		EntityManager em = PersistenceManager.getEntityManager();
		em.getTransaction().begin();
		Employee e = em.find(Employee.class, id);
		if (e!=null) {
			em.remove(e);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(int id,float salary)
	{
		EntityManager em = PersistenceManager.getEntityManager();
		em.getTransaction().begin();
		Employee e = em.find(Employee.class, id);
		e.setSalary(salary);
		em.merge(e);		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Employee> listAllEmployee()
	{
		EntityManager em=PersistenceManager.getEntityManager();
		return em.createQuery("select e from Employee e",Employee.class).getResultList();
	}
	
	public float maxSalary()
	{
		EntityManager em = PersistenceManager.getEntityManager();
		float data = (Float) em.createQuery("select max(e.salary) from Employee e").getSingleResult();
		return data;
	}
	
	public List<Employee> salaryBetween(float lowerRange,float upperRange)
	{
		EntityManager em = PersistenceManager.getEntityManager();		
		// @SuppressWarnings("unchecked")		
		List<Employee> list =em.createQuery("select e from Employee e where e.salary BETWEEN :lowerLimit AND :upperLimit",Employee.class).setParameter("lowerLimit", lowerRange).setParameter("upperLimit", upperRange).getResultList();
		return list;	
	}
	
	public Employee findEmployee(int id)
	{
		EntityManager em = PersistenceManager.getEntityManager();
		return (Employee) em.createNamedQuery("Employee_Id").setParameter("id", id).getSingleResult();		
	}
}
