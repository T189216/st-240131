package com.ll.domain.quotation.quotation.repository;

import com.ll.domain.quotation.quotation.entity.Quotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuotationRepository {
    private final List<Quotation> quotationList;
    private long lastQuotationId;

    public QuotationRepository() {
        quotationList = new ArrayList<>();
        lastQuotationId = 0;
    }

    public List<Quotation> findAll() {
        return quotationList;
    }

    public void delete(Quotation quotation) {
        quotationList.remove(quotation);
    }

    public Optional<Quotation> findById(long id) {
        return quotationList
                .stream()
                .filter(quotation -> quotation.getId() == id)
                .findFirst();
    }

    public void save(Quotation quotation) {
        if (quotation.getId() == null) {
            quotation.setId(++lastQuotationId);
            quotationList.add(quotation);
        }
    }
}