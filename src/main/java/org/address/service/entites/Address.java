package org.address.service.entites;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="sequence_address")
    private Long id;
    //for simplifying user for example he can put home or job or simple Address 5
    private String nameOfAddress;
    private String companyName;
    private String street;
    private Long houseNumber;

    @OneToOne
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private Post post;

    private String city;
    private String country;

    private boolean isDefault;

    @ManyToOne
    @JoinTable(name="address_person",
            joinColumns = { @JoinColumn(name = "addressId") },
            inverseJoinColumns = { @JoinColumn(name = "personId")} )
    private Person person;

    public Address() {
    }

    public String getNameOfAddress() {
        return nameOfAddress;
    }

    public void setNameOfAddress(String nameOfAddress) {
        this.nameOfAddress = nameOfAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Long houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(companyName, address.companyName) && Objects.equals(street, address.street) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(post.getId(), address.post.getId()) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(person.getId(), address.person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, street, houseNumber, post, city, country, person);
    }
}
