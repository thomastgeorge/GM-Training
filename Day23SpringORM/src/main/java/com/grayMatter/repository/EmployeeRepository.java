package com.grayMatter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayMatter.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByCity(String city);
	
	public List<Employee> findByDepartmentDeptId(int id);
//	OR
//	@Query(value="SELECT * FROM project23employee e where e.department_id=?", nativeQuery=true)
//	public List<Employee> findByDeptId(@Param("id") int id);
	
//--------------------------------------------------------------------------------------------------------------
//	@Query(value="SELECT * FROM project23employee e where e.emp_name like ?%", nativeQuery=true)
//	public List<Employee> findByEmpNameStartingWith(@Param("letter") String letter);
//	OR	
	public List<Employee> findByEmpNameStartingWith(String letter);
//	OR
//	@Query(value="SELECT e FROM Employee e where empName like ?1%")
//	public List<Employee> findByEmpNameStartingWith(@Param("letter") String letter);
}
