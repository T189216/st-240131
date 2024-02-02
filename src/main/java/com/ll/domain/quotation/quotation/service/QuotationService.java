package com.ll.domain.quotation.quotation.service;

import com.ll.domain.quotation.quotation.entity.Quotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuotationService {
    private final List<Quotation> quotationList;
    private long lastQuotationId;

    public QuotationService() {
        quotationList = new ArrayList<>();
        lastQuotationId = 0;
    }

    public List<Quotation> findAll() {
        return quotationList;
    }

    public void remove(Quotation quotation) {
        quotationList.remove(quotation);
    }

    public Optional<Quotation> findById(long id) {
        return quotationList
                .stream()
                .filter(quotation -> quotation.getId() == id)
                .findFirst();
    }

    public void modify(Quotation quotation, String author, String content) {
        quotation.setContent(content);
        quotation.setAuthor(author);
    }

    public Quotation write(String author, String content) {
        final long id = ++lastQuotationId;

        final Quotation quotation = new Quotation(id, content, author);
        quotationList.add(quotation);

        return quotation;
    }
}