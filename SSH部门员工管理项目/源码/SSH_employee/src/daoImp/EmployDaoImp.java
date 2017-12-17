package daoImp;

import java.util.List;

import javax.persistence.EmbeddedId;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.EmployDao;
import domain.Department;
import domain.Employee;

public class EmployDaoImp extends HibernateDaoSupport implements EmployDao{

	
	//�û�������У��
	@Override
	public Employee findUsernameAndPassword(Employee employee) {
		String hql = "from Employee where eusername=? and epassword=?";
		List<Employee> employees = (List<Employee>) this.getHibernateTemplate().find(hql, employee.getEusername(),employee.getEpassword());
		if(employees.size()>0) {
			System.out.println(employees.get(0));
			return employees.get(0);
		}	
		return null;
	}

	@Override
	public int findCount() {
		String hql = "Select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//����Ա���ķ���
	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	
	//����ID��ѯԱ���ķ���
	@Override
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	
	//�����µ�Ա����Ϣ
	@Override
	public void update(Employee employee) {
          this.getHibernateTemplate().update(employee);		
	}

	@Override
	public void delete(Employee employee) {
          this.getHibernateTemplate().delete(employee);		
	}
	
	

}
