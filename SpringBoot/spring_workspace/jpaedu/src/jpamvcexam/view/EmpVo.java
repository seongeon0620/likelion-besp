package jpamvcexam.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// DB 필드가 NULL 값 저장이 가능할 때는 타입을 참조로 하자. (integer, double)

@Entity	// 테이블 명을 클래스 명으로 인식
@Table(name="emp")	// 테이블명과 클래스명이 다를때 매핑시켜줌
public class EmpVo {
	
	@Id	// primary key
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private java.sql.Date hiredate;
	private Integer sal;	// 테이블에 null값 들어간 경우 문제 생길 수 있음
	private Integer comm;
	private int deptno;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public java.sql.Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(java.sql.Date hiredate) {
		this.hiredate = hiredate;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public Integer getComm() {
		return comm;
	}
	public void setComm(Integer comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "EmpVo [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
}
