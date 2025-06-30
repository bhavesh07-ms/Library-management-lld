package org.bhavesh.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
public class Patron {
    private String name;
    private int age;
    private String regNo;
    private List<BorrowInfo> borrowHistory;

    public void borrow(Book book, int days) {
        borrowHistory.add(new BorrowInfo(book, days));
    }

    public void returnBook(Book book) {
        borrowHistory.removeIf(info -> info.getBook().equals(book));
    }
}
