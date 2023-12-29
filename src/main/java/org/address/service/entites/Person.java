package org.address.service.entites;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="sequence")
    private Long id;
    private String name;
    private String surname;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
