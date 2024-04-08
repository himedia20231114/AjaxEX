package com.mysite.rest.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysite.rest.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// ORM ( MyBatis, JPA ) : Repository : 메소드를 사용해서 CRUD 
	//                        DAO : DB를 CRUD 쿼리하는 객체, <=== JSP   
	// Select All : findAll() , List<Employee> : select * from Employee 
	// Select     : findById(Employee)  , Optional <Employee> 
	// Update, Insert : save (Employee) 
	// delete          : delete (Empoyee) 
	

}
