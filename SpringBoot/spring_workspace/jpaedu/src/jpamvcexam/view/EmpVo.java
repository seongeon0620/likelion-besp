package jpamvcexam.view;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity	// 테이블 명을 클래스 명으로 인식
@Table(name="emp")	// 테이블명과 클래스명이 다를때 매핑시켜줌
public class EmpVo {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private java.sql.Date hiredate;
	private int sal;	// 테이블에 null값 들어간 경우 문제 생길 수 있음
	private int comm;
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
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public java.sql.Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(java.sql.Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}
