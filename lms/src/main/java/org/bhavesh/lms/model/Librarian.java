package org.bhavesh.lms.model;

import org.bhavesh.lms.service.InventoryService;
import org.bhavesh.lms.service.BookService;
import org.bhavesh.lms.service.SearchService;
import org.bhavesh.lms.service.PatronService;

public class Librarian extends User {
    private InventoryService isrvc;
    private BookService ptsrvc;
    private SearchService bksrvc;
    private PatronService patronService;

    public Librarian(String name, String employeeId) {
        super(name, employeeId);
    }
}