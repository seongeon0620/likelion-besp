package jpamvcexam.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class HelloJPA1 {
	public static void main(String[] args) {
		// 1. EntityManagerFactory 객체를 만든다.
		// Persistance.xml 파일을 읽어서 그 파일에서 emptest라는 정의를 기반으로 객체를 생성한다.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
		System.out.println("EntityManagerFactory 객체 : " + factory.getClass().getName());
		EntityManager mgr = factory.createEntityManager();
		// 생성자를 사용하지 않고 객체를 새성하는 경우 : 내부에서 할일이 많은 경우
		
		// TypesQuery : db쿼리가 아니고 orm 전용 쿼리. 데이터를 orm 객체로부터 가져온다.
		TypedQuery<EmpVo> q = mgr.createQuery("select t from EmpVo t", EmpVo.class);
		List<EmpVo> empList = q.getResultList();
		
		for (EmpVo vo : empList) {
			System.out.printf("%d %s\n", vo.getEmpno(), vo.getEname());
		}
		mgr.clear();
		factory.close();
	}
}