package org.acme.getting.started;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AddressService {

    public List<Address> getAddresses(Long name) {
        List<Address> addresses = new ArrayList<>();
        return addresses;
    }

    public String addAddresses(Address address) throws Exception {
        boolean successful = true;
        if (successful) {
            return "Address successfully added.";
        }
        throw new Exception("Error while adding Address.");
    }

    public String deleteAddress(Long id) throws Exception{
        boolean successful = false;
        if (successful) {
            return "Address successfully deleted.";
        }
        throw new Exception("Error while deleting Address.");
    }
}
