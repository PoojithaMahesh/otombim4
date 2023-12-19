package onetomanybim4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybim4.dto.Company;
import onetomanybim4.dto.Employee;

public class CmpEmpCont {
public static void main(String[] args) {
	Company company=new Company();
	company.setId(1);
	company.setName("TYSS");
	company.setGst("TYSS@123");
	
	Employee employee1=new Employee();
	employee1.setId(1);
	employee1.setName("aanib");
	employee1.setAddress("chennai");
	employee1.setCompany(company);
	
	Employee employee2=new Employee();
	employee2.setId(2);
	employee2.setName("shaik");
	employee2.setAddress("chennai");
	employee2.setCompany(company);
	
	
	List<Employee> employees=new ArrayList<Employee>();
	employees.add(employee1);
	employees.add(employee2);
	
	company.setEmployees(employees);
	
	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(company);
	entityManager.persist(employee1);
    entityManager.persist(employee2);
	entityTransaction.commit();
	
	
	
}
}
