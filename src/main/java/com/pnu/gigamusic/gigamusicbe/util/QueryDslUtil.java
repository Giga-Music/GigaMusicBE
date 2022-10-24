package com.pnu.gigamusic.gigamusicbe.util;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class QueryDslUtil {

    private static JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    public static JPAQueryFactory getQueryFactory() {
        return queryFactory;
    }

}
