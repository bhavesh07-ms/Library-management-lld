package org.bhavesh.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
public class Patron extends User {

    private List<BorrowInfo> borrowHistory;

    public Patron(String name, String id) {
        super(name, id); // name → from User, regNo → set as id
        this.borrowHistory = new ArrayList<>();
    }


    public void borrow(Book book, int days) {
        borrowHistory.add(new BorrowInfo(book, days));
    }

    public void returnBook(Book book) {
        borrowHistory.removeIf(info -> info.getBook().equals(book));
    }

    public List<BorrowInfo> getOverdueBooks() {
        return borrowHistory.stream()
                .filter(info -> info.isOverdue())
                .toList();
    }
}
