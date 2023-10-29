package com.tuana9a.learnjavaspringweb.specification;

import lombok.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;

@Getter
@Setter

@AllArgsConstructor
public class BaseSpecification<T> implements Specification<T> {

    private SearchCriteria search;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        try {
            switch (search.getOperation()) {
                case ">":
                    return builder.greaterThan(root.get(search.getKey()), search.getValue().toString());
                case ">=":
                    return builder.greaterThanOrEqualTo(root.get(search.getKey()), search.getValue().toString());
                case "<":
                    return builder.lessThan(root.get(search.getKey()), search.getValue().toString());
                case "<=":
                    return builder.lessThanOrEqualTo(root.get(search.getKey()), search.getValue().toString());
                case "=":
                    return builder.equal(root.get(search.getKey()), search.getValue());
                case "==": // for parent comparing
                    return builder.equal(root.get(search.getKey()).get("id"), search.getValue());
                case "!=":
                    return builder.notEqual(root.get(search.getKey()), search.getValue().toString());
                case "%":
                    return builder.like(root.get(search.getKey()), "%" + search.getValue() + "%");
                case ":":
                    return search.getValue().toString()
                            .equalsIgnoreCase("null") ?
                            root.get(search.getKey()).isNull() : root.get(search.getKey()).isNotNull();
                case "<<":
                    return root.get(search.getKey()).in(
                            Arrays.stream(search.getValue().toString().split(";")).map(str -> (Object) str).toArray()
                    );
                default:
                    return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
