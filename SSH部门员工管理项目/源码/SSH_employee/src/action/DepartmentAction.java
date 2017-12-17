package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Department;
import domain.PageBean;
import service.DepartmentService;

/*
 * ���Ź���Action
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




//��ѯ�ķ�������ҳ�Ĳ�ѯ��
public String findAll() {
	PageBean<Department> pageBean = departmentService.findByPage(currentPage);
	System.out.println("findAll");
	//��pageBean���뵽ֵջ��
	ActionContext.getContext().getValueStack().push(pageBean);
	return "findAll";
	
}

//ҳ����ת
public String saveUI() {
	return "saveUI";
}

//��Ӳ���ִ�з���
public String save() {
	departmentService.save(department);
	return "saveSuccess";
}

//�༭����
public String edit() {
	department = departmentService.findById(department.getDid());
	return "editSuccess";
}
//�޸Ĳ�����Ϣ
public String update() {
	departmentService.update(department);
	return "updateSuccess";
}	

//ɾ������
public String delete() {
	//�Ȳ�ѯ��ɾ��������ʵ�ּ���ɾ��
	department = departmentService.findById(department.getDid());
	departmentService.delete(department);
    return "deleteSuccess";
}

}
