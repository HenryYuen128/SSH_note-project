package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Department;
import domain.PageBean;
import service.DepartmentService;

/*
 * 部门管理Action
 * */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
  private Department department = new Department();

@Override
public Department getModel() {
	return department;
}
  
private Integer currentPage = 1;
	public void setCurrentPage(Integer currentPage) {
	this.currentPage = currentPage;
}

private DepartmentService departmentService;
public void setDepartmentService(DepartmentService departmentService) {
	this.departmentService = departmentService;
}




//查询的方法（分页的查询）
public String findAll() {
	PageBean<Department> pageBean = departmentService.findByPage(currentPage);
	System.out.println("findAll");
	//将pageBean存入到值栈中
	ActionContext.getContext().getValueStack().push(pageBean);
	return "findAll";
	
}

//页面跳转
public String saveUI() {
	return "saveUI";
}

//添加部门执行方法
public String save() {
	departmentService.save(department);
	return "saveSuccess";
}

//编辑部门
public String edit() {
	department = departmentService.findById(department.getDid());
	return "editSuccess";
}
//修改部门信息
public String update() {
	departmentService.update(department);
	return "updateSuccess";
}	

//删除部门
public String delete() {
	//先查询后删除，可以实现级联删除
	department = departmentService.findById(department.getDid());
	departmentService.delete(department);
    return "deleteSuccess";
}

}
