package service;

import domain.Employee;
import domain.PageBean;
/*员工管理接口*/
public interface EmployService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currentPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
