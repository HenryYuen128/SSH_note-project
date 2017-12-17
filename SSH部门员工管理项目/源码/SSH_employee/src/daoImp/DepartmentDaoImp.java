package daoImp;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.DepartmentDao;
import domain.Department;
@Transactional
public class DepartmentDaoImp extends HibernateDaoSupport implements DepartmentDao{

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public int findCount() {
		String hql = "Select count(*) from Department";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public void save(Department department) {
              this.getHibernateTemplate().save(department);		
	}

	@Override
	public Department findById(Integer did) {
        
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override
	public void delete(Department department) {
        this.getHibernateTemplate().delete(department);		
	}

	@Override
	public List<Department> findAll() {
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}

}
