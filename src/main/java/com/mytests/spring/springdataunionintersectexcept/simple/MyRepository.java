package com.mytests.spring.springdataunionintersectexcept.simple;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyRepository {
    private final EntityManager entityManager;

    @Transactional
    public void populateBD(){

        MyFirstEntity f0 = new MyFirstEntity(0L, "xxx");
        MyFirstEntity f1 = new MyFirstEntity(1L, "aaa");
        MyFirstEntity f2 = new MyFirstEntity(2L, "bbb");
        MySecondEntity s0 = new MySecondEntity(0L, "xxx");
        MySecondEntity s1 = new MySecondEntity(1L, "ccc");
        MySecondEntity s2 = new MySecondEntity(2L, "ddd");
        MyThirdEntity t1 = new MyThirdEntity(1L, "eee");
        MyThirdEntity t2 = new MyThirdEntity(2L, "ccc");
        MyThirdEntity t3 = new MyThirdEntity(3L, "bbb");
        entityManager.persist(f0);
        entityManager.persist(f1);
        entityManager.persist(f2);
        entityManager.persist(s0);
        entityManager.persist(s1);
        entityManager.persist(s2);
        entityManager.persist(t1);
        entityManager.persist(t2);
        entityManager.persist(t3);
    }

    public MyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<String> useUnion(){
       String query =  """
            select f.name as name from MyFirstEntity f
            union
            select s.name as name from MySecondEntity s
            """;
       return entityManager.createQuery(query, String.class).getResultList();
    };
    public List<String> useUnionAll(){
       String query =  """
            select f.name as name from MyFirstEntity f
            union all
            select s.name as name from MySecondEntity s
            """;
       return entityManager.createQuery(query, String.class).getResultList();
    };

    public List<String> useIntersect(){
       String query =  """
            select f.name as name from MyFirstEntity f
            intersect
            select s.name as name from MySecondEntity s
            """;
       return entityManager.createQuery(query, String.class).getResultList();
    };
    public List<String> useExcept(){
       String query =  """
            select f.name as name from MyFirstEntity f
            except
            select s.name as name from MySecondEntity s
            """;
       return entityManager.createQuery(query, String.class).getResultList();
    };

    public List<String> useNestedUnion(){
        String query =  """
            select t.name from MyThirdEntity t where
            t.name in (
            select f.name as name from MyFirstEntity f
            union all
            select s.name as name from MySecondEntity s
            )
            """;
        return entityManager.createQuery(query, String.class).getResultList();

    }

}
