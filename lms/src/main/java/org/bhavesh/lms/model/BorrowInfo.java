package org.bhavesh.lms.model;

import lombok.Data;

import java.time.LocalDate;


@Data
public class BorrowInfo {
    private Book book;
    private LocalDate borrowDate;
    private int days;

    public BorrowInfo(Book book, int days) {
        this.book = book;
        this.days = days;
        this.borrowDate = LocalDate.now();
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(borrowDate.plusDays(days));
    }
}