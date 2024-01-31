package com.ll.domain.quotation.quotation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quotation {
    private final long id;
    private final String content;
    private final String author;
}