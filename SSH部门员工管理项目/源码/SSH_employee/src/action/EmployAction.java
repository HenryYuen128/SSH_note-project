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
			this.addActionError("用户名或密码错误！");
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
	//添加员工页面跳转
	public String saveUI() {
		//查询所有部门
		List<Department> departments = departmentService.findAll();
		//集合用set，对象用push简单点
		ActionContext.getContext().getValueStack().set("list", departments);
		return "saveUI";
	}
	
	//添加员工
	public String save() {
		employService.save(employee);
		return "saveSuccess";
	}
	
	//修改员工
	public String edit() {
		//根据员工ID查询员工
		employee = employService.findById(employee.getEid());
		//查询所有部门
		List<Department> departments = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", departments);
		return "editSuccess";
	}
	
	//保存修改的员工信息
	public String update() {
		employService.update(employee);
		return "updateSuccess";
		
	}
	//删除员工信息
	public String delete() {
		employee = employService.findById(employee.getEid());
		employService.delete(employee);
		return "deleteSuccess";
	}
	
}
