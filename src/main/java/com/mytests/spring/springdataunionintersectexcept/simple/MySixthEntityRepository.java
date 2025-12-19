package com.mytests.spring.springdataunionintersectexcept.simple;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MySixthEntityRepository extends CrudRepository<MySixthEntity, Long> {

    @Query(
            """
                  INSERT INTO MySixthEntity (name)
                  SELECT e.name
           FROM MySixthEntity e
           WHERE 1=1
           union
           SELECT e2.name
           FROM MySixthEntity e2
           """
    )
    List<MySixthEntity> test();
}
