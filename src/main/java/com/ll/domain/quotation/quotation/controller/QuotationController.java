package com.ll.domain.quotation.quotation.controller;

import com.ll.domain.quotation.quotation.entity.Quotation;
import com.ll.domain.quotation.quotation.service.QuotationService;
import com.ll.global.rq.Rq;

import java.util.Optional;
import java.util.Scanner;

public class QuotationController {
    private final Scanner scanner;
    private final QuotationService quotationService;

    public QuotationController(Scanner scanner) {
        this.scanner = scanner;
        quotationService = new QuotationService();
    }

    public void actionModify(Rq rq) {
        final long id = rq.getParameterAsLong("id", 0);

        Optional<Quotation> quotationOpt = quotationService.findById(id);

        quotationOpt
                .ifPresentOrElse(
                        quotation -> {
                            System.out.println("명언(기존) : %s".formatted(quotation.getContent()));
                            System.out.print("명언: ");
                            final String content = scanner.nextLine().trim();

                            System.out.println("작가(기존) : %s".formatted(quotation.getAuthor()));
                            System.out.print("작가: ");
                            final String author = scanner.nextLine().trim();

                            quotationService.modify(quotation, author, content);

                            System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
                        },
                        () -> System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id))
                );
    }

    public void actionDelete(Rq rq) {
        final long id = rq.getParameterAsLong("id", 0);

        Optional<Quotation> quotationOpt = quotationService.findById(id);

        quotationOpt
                .ifPresentOrElse(
                        quotation -> {
                            quotationService.remove(quotation);
                            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
                        },
                        () -> System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id))
                );
    }

    public void actionShowList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");

        quotationService.findAll()
                .reversed()
                .forEach(
                        quotation -> System.out.println(
                                "%d / %s / %s".formatted(
                                        quotation.getId(),
                                        quotation.getAuthor(),
                                        quotation.getContent()
                                )
                        )
                );
    }

    public void actionWrite() {
        System.out.print("명언: ");
        final String content = scanner.nextLine().trim();

        System.out.print("작가: ");
        final String author = scanner.nextLine().trim();

        final Quotation quotation = quotationService.write(author, content);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(quotation.getId()));
    }

    public void dispatch(Rq rq) {
        switch (rq.getAction()) {
            case "등록" -> actionWrite();
            case "삭제" -> actionDelete(rq);
            case "수정" -> actionModify(rq);
            case "목록" -> actionShowList();
        }
    }
}
