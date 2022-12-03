package com.pnu.gigamusic.gigamusicbe.repository;

import com.pnu.gigamusic.gigamusicbe.domain.PlayList;
import com.pnu.gigamusic.gigamusicbe.domain.QPlayList;
import com.pnu.gigamusic.gigamusicbe.util.QueryDslUtil;
import com.querydsl.core.types.Order;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {

    QPlayList qPlayList = QPlayList.playList;

    default List<PlayList> findAll(String name, String sort) {
        JPAQuery<PlayList> query = QueryDslUtil.getQueryFactory()
                .selectFrom(qPlayList);
        if (name != null && !name.isBlank()) {
            query.where(qPlayList.name.contains(name));
        }
        if (sort != null && !sort.isBlank()) {
            String[] fieldName2order = sort.split(":");
            String fieldName = fieldName2order[0];
            Order order = getOrderFromString(fieldName2order[1]);
            switch (fieldName) {
                case "name" -> query.orderBy(order == Order.ASC ? qPlayList.name.asc() : qPlayList.name.desc());
                case "rating" -> query.orderBy(order == Order.ASC ? qPlayList.rating.asc() : qPlayList.rating.desc());
                default -> throw new IllegalArgumentException("invalid param fieldName: " + fieldName);
            }
        }
        return query.fetch();
    }

    private static Order getOrderFromString(String order) {
        return switch (order) {
            case "asc" -> Order.ASC;
            case "desc" -> Order.DESC;
            default -> throw new IllegalArgumentException("invalid param order: " + order);
        };
    }

}
