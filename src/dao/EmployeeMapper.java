package dao;

import java.util.List;

import entity.EmployeeProperty;

public interface EmployeeMapper {
	public	List<EmployeeProperty> getEmployeeList(); 
	public  boolean delById(String id);
}
