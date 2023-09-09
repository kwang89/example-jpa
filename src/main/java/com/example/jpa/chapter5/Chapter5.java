package com.example.jpa.chapter5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
public class Chapter5 {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-jpa");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {

        String id = "id1";
        Chapter5Member member = new Chapter5Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);

        //등록
        em.persist(member);

        //한 건 조회
        Chapter5Member findMember = em.find(
            Chapter5Member.class, id);
        System.out.println("id= " + id + ", findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());

        //수정
        member.setAge(20);

        //한 건 조회
        Chapter5Member findMember2 = em.find(
            Chapter5Member.class, id);
        System.out.println("id= " + id + ", findMember=" + findMember2.getUsername() + ", age=" + findMember2.getAge());

        //목록 조회
        List<Chapter5Member> members = em.createQuery("select a from Chapter4Member a", Chapter5Member.class).getResultList();
        System.out.println("members.size=" + members.size());

        //삭제
        em.remove(member);

    }
}
