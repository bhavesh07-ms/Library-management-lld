package org.bhavesh.lms.service;

import org.bhavesh.lms.model.Book;
import org.bhavesh.lms.repository.Inventory;

public class InventoryService {
    private final Inventory inventory;

    public InventoryService(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean addBook(Book book) {
        return inventory.addBook(book);
    }

    public boolean removeBook(String isbn) {
        return inventory.removeBookByIsbn(isbn);
    }
}