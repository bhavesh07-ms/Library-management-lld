package org.bhavesh.lms.service;

import org.bhavesh.lms.model.BorrowInfo;
import org.bhavesh.lms.model.Library;
import org.bhavesh.lms.model.Patron;

public class PatronService {
    private Library library;

    public PatronService(Library library) {
        this.library = library;
    }

    public boolean addPatron(Patron patron) {
        return library.addPatron(patron);
    }

    public boolean updatePatron(String regNo, Patron updated) {
        return library.updatePatron(regNo, updated);
    }

    public void trackPatronHistory(Patron patron) {
        for (BorrowInfo info : patron.getBorrowHistory()) {
            System.out.println("Borrowed: " + info.getBook().getTitle() +
                    ", Due: " + info.isOverdue());
        }
    }
}