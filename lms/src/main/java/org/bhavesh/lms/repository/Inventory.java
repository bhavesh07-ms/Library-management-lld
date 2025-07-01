package org.bhavesh.lms.repository;

import org.bhavesh.lms.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<Book> books = new ArrayList<>();
    private Map<String, Book> isbnMap = new HashMap<>();

    public boolean addBook(Book book) {
        if (isbnMap.containsKey(book.getIsbn())) return false;
        books.add(book);
        isbnMap.put(book.getIsbn(), book);
        return true;
    }

    public boolean removeBookByIsbn(String isbn) {
        return books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findAvailableBookByIsbn(String isbn) {
        if (isbnMap.containsKey(isbn))
            return isbnMap.get(isbn);
        return null;
    }
}
