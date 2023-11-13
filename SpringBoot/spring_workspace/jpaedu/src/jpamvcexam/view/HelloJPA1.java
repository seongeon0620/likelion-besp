package jpamvcexam.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HelloJPA1 {
	public static void main(String[] args) {
		// 1. EntityManagerFactory 객체를 만든다.
		// Persistance.xml 파일을 읽어서 그 파일에서 emptest라는 정의를 기반으로 객체를 생성한다.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
		System.out.println("EntityManagerFactory 객체 : " + factory.getClass().getName());
		EntityManager mgr = factory.createEntityManager();
		factory.close();
	}
}