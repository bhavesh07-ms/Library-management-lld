package org.bhavesh.lms.service.strategy;

import org.bhavesh.lms.model.Book;

import java.util.List;

public interface SearchStrategy {
    List<Book> search(List<Book> books, String keyword);
}
