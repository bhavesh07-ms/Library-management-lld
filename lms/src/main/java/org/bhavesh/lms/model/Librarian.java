package org.bhavesh.lms.model;

import lombok.Data;
import lombok.Getter;
import org.bhavesh.lms.repository.Inventory;
import org.bhavesh.lms.service.InventoryService;
import org.bhavesh.lms.service.BookService;
import org.bhavesh.lms.service.SearchService;
import org.bhavesh.lms.service.PatronService;

@Getter
public class Librarian extends User {
    private InventoryService isrvc;
    private BookService ptsrvc;
    private SearchService bksrvc;
    private PatronService patronService;

    public Librarian(String name, String employeeId, Library library) {
        super(name, employeeId);
        this.isrvc = new InventoryService(library.getInventory());
        this.ptsrvc = new BookService(library.getInventory());
        this.bksrvc = new SearchService(library.getInventory());
        this.patronService = new PatronService(library);
    }


    public InventoryService getInventoryService() {
        return this.isrvc;
    }

    public BookService getBookService() {
        return this.ptsrvc;
    }

    public SearchService getSearchService() {
        return this.bksrvc;
    }
}