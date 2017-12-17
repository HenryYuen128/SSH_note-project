package dao;

import java.util.List;

import domain.Employee;

public interface EmployDao {

	Employee findUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);


	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
