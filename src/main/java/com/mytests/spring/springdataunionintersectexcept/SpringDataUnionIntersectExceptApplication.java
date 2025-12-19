package com.mytests.spring.springdataunionintersectexcept;

import com.mytests.spring.springdataunionintersectexcept.simple.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataUnionIntersectExceptApplication implements CommandLineRunner {

@Autowired
ApplicationContext ctx;
    private final MyRepository myRepository;

    public SpringDataUnionIntersectExceptApplication( MyRepository myRepository) {

        this.myRepository = myRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataUnionIntersectExceptApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        myRepository.populateBD();
        System.out.println("use 'union all': "+myRepository.useUnionAll());
        System.out.println("use 'union': "+myRepository.useUnion());
        System.out.println("use 'intersect': "+myRepository.useIntersect());
        System.out.println("use 'except': "+myRepository.useExcept());
        System.out.println("use nested 'union all': "+myRepository.useNestedUnion());
        System.out.println("use subquery with association: "+myRepository.useSubquery());
        System.out.println("use case with plus-connected subqueries: "+myRepository.useCaseWithPlus());
        System.out.println("use case with ||-connected subqueries: "+myRepository.useCaseWithConcat());
        System.out.println("use case with OR: "+myRepository.useCaseWithOr());
        System.out.println("use case expression: "+myRepository.useCase());
        System.out.println("use plus-connected subqueries: "+myRepository.usePlusWithSubqueries());
        System.out.println("use concatenated subquaries: "+myRepository.useConcatWithSunqueries());
        System.out.println("use and-connected subqueries: "+myRepository.useAndWithSubqueries());
        System.out.println("use insert with union expr: " + myRepository.insertWithUnion());
    }
}
