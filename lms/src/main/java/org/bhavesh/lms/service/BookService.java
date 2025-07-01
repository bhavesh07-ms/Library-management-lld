package org.bhavesh.lms.service;

import org.bhavesh.lms.model.Book;
import org.bhavesh.lms.model.BorrowInfo;
import org.bhavesh.lms.model.Library;
import org.bhavesh.lms.model.Patron;
import org.bhavesh.lms.repository.Inventory;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final Inventory inventory;

    public BookService(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean borrowBook(Patron patron, String keyword, int days) {
        Book book = inventory.findAvailableBookByIsbn(keyword);
        // modify to borrowbook by title or author problem is need single book
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

    public void isAnyBookOverdue(Library library) {
        for (Patron patron : library.getPatrons()) {
            for (BorrowInfo info : patron.getBorrowHistory()) {
                if (!info.isReturned() && info.isOverdue()) {
                    System.out.println("Overdue Book Found:");
                    System.out.println("Patron: " + patron.getName() + ", Book: " +
                            info.getBook().getTitle() + " [ISBN: " + info.getBook().getIsbn() + "]");
                }
            }
        }
    }

    public void getAllBookStatus() {
        List<Book> borrowed = new ArrayList<>();
        List<Book> available = new ArrayList<>();

        for (Book book : inventory.getBooks()) {
            if (book.isBorrowed()) {
                borrowed.add(book);
            } else {
                available.add(book);
            }
        }

        System.out.println("Borrowed Books:");
        borrowed.forEach(book -> System.out.println(book.getTitle() + " - " + book.getIsbn()));

        System.out.println("Available Books:");
        available.forEach(book -> System.out.println(book.getTitle() + " - " + book.getIsbn()));
    }
}

