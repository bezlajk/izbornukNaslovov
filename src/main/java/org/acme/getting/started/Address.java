package org.acme.getting.started;

public class Address extends MyEntity {
    //for simplifying user for example he can put home or job or simple Address 5
    private String nameOfAddress;
    private String companyName;
    private String street;
    private Long houseNumber;
    private Long postNumber;
    private String post;
    private String city;
    private String country;

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

    public Long getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Long postNumber) {
        this.postNumber = postNumber;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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
}
