package org.acme.getting.started;


import java.util.ArrayList;
import java.util.List;


public class Person extends MyEntity {
    private String name;
    private String surname;
    private List<Long> addressId = new ArrayList<>();



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

    public List<Long> getAddressId() {
        return addressId;
    }

    public void setAddressId(List<Long> addressId) {
        this.addressId = addressId;
    }

}
