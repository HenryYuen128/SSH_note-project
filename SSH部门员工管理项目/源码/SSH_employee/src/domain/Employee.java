package domain;

import java.util.Date;

/*Emplyee Entity
 * */

public class Employee {

	private Integer eid;
	private String ename;
	private String egender;
	private Date ebirthday;
	private Date ehiredday;
	private String eno;
	private String eusername;
	private String epassword;
	private Department department;
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEgender() {
		return egender;
	}
	public void setEgender(String egender) {
		this.egender = egender;
	}
	public Date getEbirthday() {
		return ebirthday;
	}
	public void setEbirthday(Date ebirthday) {
		this.ebirthday = ebirthday;
	}
	public Date getEhiredday() {
		return ehiredday;
	}
	public void setEhiredday(Date ehiredday) {
		this.ehiredday = ehiredday;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getEusername() {
		return eusername;
	}
	public void setEusername(String eusername) {
		this.eusername = eusername;
	}
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", egender=" + egender + ", ebirthday=" + ebirthday
				+ ", ehiredday=" + ehiredday + ", eno=" + eno + ", eusername=" + eusername + ", epassword=" + epassword
				+ ", department=" + department + "]";
	}


}
