package org.bhavesh.lms.repository;

import org.bhavesh.lms.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public boolean removeBookByIsbn(String isbn) {
        return books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findAvailableBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn) && !book.isBorrowed())
                .findFirst().orElse(null);
    }
}
