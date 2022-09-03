package com.fpr.persistence.query;

import com.fpr.domain.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.fpr.domain.QSaving.*;

@Repository
@RequiredArgsConstructor
public class ProductQueryRepository {

    private final JPAQueryFactory qf;

    public List<Saving> findTemp(int memberAge){

        return qf.selectFrom(saving)
                .where(
                        condition(memberAge, saving.joinWay)
                )
                .fetch();
    }

    public BooleanBuilder condition(int age, StringPath entityPath){

        BooleanBuilder builder = new BooleanBuilder();

        if (age >= 1 && age < 30){
            return builder.and(entityPath.contains("스마트폰"));
        } else if (age >= 30 && age < 40){
            return builder.and(entityPath.contains("영업점").and(entityPath.contains("인터넷").and(entityPath.contains("스마트폰"))));
        } else if (age >= 40 && age < 50){
            return builder.and(entityPath.contains("전화"));
        } else {
            return builder.and(entityPath.eq("영업점"));
        }
    }

}