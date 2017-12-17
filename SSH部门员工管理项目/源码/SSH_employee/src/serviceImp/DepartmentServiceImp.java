package serviceImp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.DepartmentDao;
import domain.Department;
import domain.PageBean;
import service.DepartmentService;
@Transactional
public class DepartmentServiceImp implements DepartmentService{

	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	//��ҳ��ѯ
	@Override
	public PageBean<Department> findByPage(Integer currentPage) {
		PageBean<Department> pageBean =new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrentPage(currentPage);
		//��װÿҳ��ʾ��¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);//����ȡ��
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currentPage-1)*pageSize;//��ҳÿҳ��ʼ������
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		
		System.out.println(list.get(0));
		
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Department department) {
            departmentDao.save(department);
	}

	@Override
	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}

	@Override
	public void update(Department department) {
    departmentDao.update(department);
	}

	@Override
	public void delete(Department department) {
     departmentDao.delete(department);		
	}
//��ѯ���в���
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	
	
	
}
