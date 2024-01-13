package org.address.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.address.service.entites.Address;
import org.address.service.entites.Person;

import java.util.List;

@Path("/")
public class AddressResource {

    @Inject
    AddressService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("address/get/{id}")
    public Address getAddress(Long id) {
        return service.getAddress(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("person/get/{id}")
    public Person getPerson(Long id) {
        return service.getPerson(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("person/{personId}/default/address/{addressId}")
    public String setDefaultAddress(Long personId, Long addressId) {
        return service.setDefaultAddress(personId, addressId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("address/get/")
    public List<Address> getAddresses() {
        return service.getAddresses();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("person/get/")
    public List<Person> getPersons() {
        return service.getPersons();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("address/get/person/{id}")
    public List<Address> getAddressesPerPerson(Long id) {
        return service.getAddressesPerPerson(id);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("address/add/")
    public Address addAddress(Address address) throws Exception {
        return service.addAddress(address);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("person/add/")
    public Person addPerson(Person person) throws Exception {
        return service.addPerson(person);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("address/delete/{id}")
    public String deleteAddress(Long id) throws Exception {
        return service.deleteAddress(id);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("person/delete/{id}")
    public String deletePerson(Long id) throws Exception {
        return service.deletePerson(id);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "Hello I'll provide some addresses.";
    }
}