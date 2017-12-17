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

	
	//��ҳ��ѯԱ��
	@Override
	public PageBean<Employee> findByPage(Integer currentPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//��װ��ǰҳ��
		pageBean.setCurrentPage(currentPage);
		//��װÿҳ��ʾ��¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = employDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);//����ȡ��
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currentPage-1)*pageSize;//��ҳÿҳ��ʼ������
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
