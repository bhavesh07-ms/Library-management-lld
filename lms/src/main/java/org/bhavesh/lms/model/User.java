package org.bhavesh.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public abstract class User {
     String name;
     String id;
    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
