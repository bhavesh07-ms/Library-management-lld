package org.bhavesh.lms.service;

import org.bhavesh.lms.model.Book;
import org.bhavesh.lms.model.Patron;
import org.bhavesh.lms.repository.Inventory;

public class LendingService {
    private final Inventory inventory;

    public LendingService(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean borrowBook(Patron patron, String isbn, int days) {
        Book book = inventory.findAvailableBookByIsbn(isbn);
        if (book == null) return false;

        book.setBorrowed(true);
        patron.borrow(book, days);
        return true;
    }

    public boolean returnBook(Patron patron, String isbn) {
        Book book = inventory.getBooks().stream()
                .filter(b -> b.getIsbn().equals(isbn) && b.isBorrowed())
                .findFirst().orElse(null);
        if (book == null) return false;

        patron.returnBook(book);
        book.setBorrowed(false);
        return true;
    }
}
