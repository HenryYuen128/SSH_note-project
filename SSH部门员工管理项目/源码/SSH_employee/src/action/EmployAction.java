package action;


import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Department;
import domain.Employee;
import domain.PageBean;
import service.DepartmentService;
import service.EmployService;

public class EmployAction extends ActionSupport implements ModelDriven<Employee>{
  
	private Employee employee =new Employee();
	private EmployService employService;
	private DepartmentService departmentService;
	
	

	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setEmployService(EmployService employService) {
		this.employService = employService;
	}

	/*login method*/
	public String login() {
		
		System.out.println("login.....");
		System.out.println(employee);
		Employee existEmployee = employService.login(employee);
		if(existEmployee==null) {
			this.addActionError("�û������������");
			System.out.println("error");
			return INPUT;
		}else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
	}

	@Override
	public Employee getModel() {
		
		return employee;
	}


	private Integer currentPage = 1;


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public String findAll() {
		PageBean<Employee> pageBean = employService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
		
	}
	//���Ա��ҳ����ת
	public String saveUI() {
		//��ѯ���в���
		List<Department> departments = departmentService.findAll();
		//������set��������push�򵥵�
		ActionContext.getContext().getValueStack().set("list", departments);
		return "saveUI";
	}
	
	//���Ա��
	public String save() {
		employService.save(employee);
		return "saveSuccess";
	}
	
	//�޸�Ա��
	public String edit() {
		//����Ա��ID��ѯԱ��
		employee = employService.findById(employee.getEid());
		//��ѯ���в���
		List<Department> departments = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", departments);
		return "editSuccess";
	}
	
	//�����޸ĵ�Ա����Ϣ
	public String update() {
		employService.update(employee);
		return "updateSuccess";
		
	}
	//ɾ��Ա����Ϣ
	public String delete() {
		employee = employService.findById(employee.getEid());
		employService.delete(employee);
		return "deleteSuccess";
	}
	
}
