package org.bhavesh.lms.model;

import lombok.Getter;
import lombok.Setter;
import org.bhavesh.lms.repository.Inventory;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Library {
    private String name;
    private String address;
    private Inventory inventory;
    private List<Librarian> librarians;
    private List<Patron> patrons;

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.inventory = new Inventory();
        this.librarians = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }
    public boolean addPatron(Patron patron) {
        return patrons.add(patron);
    }

    public boolean updatePatron(String regNo, Patron updated) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getId().equals(regNo)) {
                patrons.set(i, updated);
                return true;
            }
        }
        return false;
    }

    public boolean addLibrarian(Librarian librarian) {
        return librarians.add(librarian);
    }
}
