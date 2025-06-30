package org.bhavesh.lms.service;

import org.bhavesh.lms.model.Book;
import org.bhavesh.lms.repository.Inventory;
import org.bhavesh.lms.service.strategy.SearchStrategy;

import java.util.List;

public class SearchService {
    private final Inventory inventory;
    private SearchStrategy strategy;

    public SearchService(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Book> search(String keyword) {
        return strategy.search(inventory.getBooks(), keyword);
    }
}
