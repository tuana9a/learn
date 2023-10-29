package com.tuana9a.learnjavaspringweb.dto;

import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PageJsonResponse<T> {

    public PageJsonResponse(Page<T> page) {
        this.content = page.getContent();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();
    }

    private List<T> content;
    private int totalPages;
    private long totalElements;
    private boolean last;
}
