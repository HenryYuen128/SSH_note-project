package serviceImp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.EmployDao;
import daoImp.EmployDaoImp;
import domain.Department;
import domain.Employee;
import domain.PageBean;
import service.EmployService;
@Transactional
public class EmployServiceImp implements EmployService{
	private EmployDao employDao;

	public void setEmployDao(EmployDao employDao) {
		this.employDao = employDao;
	}

	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employDao.findUsernameAndPassword(employee);
		return existEmployee;
	}

	
	//分页查询员工
	@Override
	public PageBean<Employee> findByPage(Integer currentPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前页数
		pageBean.setCurrentPage(currentPage);
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currentPage-1)*pageSize;//分页每页开始的数据
		List<Employee> list = employDao.findByPage(begin,pageSize);
				
		System.out.println(list.get(0));
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		employDao.save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		
		return employDao.findById(eid);
	}

	@Override
	public void update(Employee employee) {
         employDao.update(employee);		
	}

	@Override
	public void delete(Employee employee) {
         employDao.delete(employee);		
	}
 
    
}
