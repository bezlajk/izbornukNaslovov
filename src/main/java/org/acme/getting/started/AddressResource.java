package org.acme.getting.started;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/address")
public class AddressResource {

    @Inject
    AddressService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{accountId}")
    public List<Address> getAddresses(Long accountId) {
        return service.getAddresses(accountId);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add/")
    public String addAddress(Address address) throws Exception {
        return service.addAddresses(new Address()
        );
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public String deleteAddress(Long id) throws Exception {
        return service.deleteAddress(id);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello I'll provide some addresses.";
    }
}