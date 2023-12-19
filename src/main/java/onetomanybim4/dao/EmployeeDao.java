package onetomanybim4.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import onetomanybim4.dto.Employee;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	public void saveEmployee(Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	public void updateEmployee(int id,Employee employee) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			employee.setId(id);
			employee.setCompany(dbEmployee.getCompany());
			
			entityManager.merge(employee);
			entityTransaction.commit();	
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void findEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
			System.out.println(dbEmployee);
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	public void deleteEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbEmployee);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
