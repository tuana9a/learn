package com.tuana9a.learnjavaspringweb.specification;


import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecificationBuilder<T> {
    private final List<SearchCriteria> criteriaSearches;

    public SpecificationBuilder() {
        criteriaSearches = new LinkedList<>();
    }

    public Specification<T> resolve(List<String> stringSearches) {
        if (stringSearches == null) {
            stringSearches = new ArrayList<>();
        }
        SpecificationBuilder<T> builder = new SpecificationBuilder<>();
        Pattern pattern = Pattern.compile("(\\w+?)(>=|<=|<<|!=|==|%|:|=|<|>)(.*)");
        for (String param : stringSearches) {
            Matcher matcher = pattern.matcher(param);
            if (matcher.find()) {
                if (matcher.group(3).equalsIgnoreCase("true")) {
                    builder.with(matcher.group(1), matcher.group(2), true);
                } else if (matcher.group(3).equalsIgnoreCase("false")) {
                    builder.with(matcher.group(1), matcher.group(2), false);
                } else {
                    builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
                }
            }
        }
        builder.with("deleted", "=", false);
        return builder.build();
    }

    private Specification<T> build() {
        if (criteriaSearches.isEmpty()) return null;
        Specification<T> finalSpecification = new BaseSpecification<T>(criteriaSearches.get(0));
        for (int i = 1, length = criteriaSearches.size(); i < length; i++) {
            finalSpecification.and(new BaseSpecification<T>(criteriaSearches.get(i)));
        }
        return finalSpecification;
    }

    private void with(String key, String operation, Object value) {
        criteriaSearches.add(new SearchCriteria(key, operation, value));
    }
}
