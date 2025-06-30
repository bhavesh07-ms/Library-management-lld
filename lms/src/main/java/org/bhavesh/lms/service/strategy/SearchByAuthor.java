package org.bhavesh.lms.service.strategy;

import org.bhavesh.lms.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByAuthor implements SearchStrategy {
    public List<Book> search(List<Book> books, String keyword) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
