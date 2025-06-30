package org.bhavesh.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private String isbn;
    private int pubYear;
    private boolean isBorrowed;

}