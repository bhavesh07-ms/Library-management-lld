package org.bhavesh.lms.service.strategy;

import org.bhavesh.lms.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByTitle implements SearchStrategy {
    public List<Book> search(List<Book> books, String keyword) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}