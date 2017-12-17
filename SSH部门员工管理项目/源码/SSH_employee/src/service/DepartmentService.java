package service;

import java.util.List;

import domain.Department;
import domain.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currentPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
