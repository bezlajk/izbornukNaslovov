package org.address.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.address.service.entites.Address;
import org.address.service.entites.Person;
import org.address.service.repository.AddressRepository;
import org.address.service.repository.PersonRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AddressService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public AddressService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    public List<Address> getAddresses() {
        List<Address> addresses = new ArrayList<>();
        addresses.addAll((Collection<? extends Address>) addressRepository.findAll());
        return addresses;
    }

    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        personList.addAll((Collection<? extends Person>) personRepository.findAll());
        return personList;
    }

    public List<Address> getAddressesPerPerson(Long id) {
        return addressRepository.findByPersonId(id);
    }

    public Address getAddress(Long id) {
        return addressRepository.findById(id).get();
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).get();
    }

    public Address addAddress(Address address) throws Exception {
        try {
            List<Address> addresses = new ArrayList<>();
            if (address.getPerson().getId()==null){
                Person person = personRepository.save(address.getPerson());
                address.setPerson(person);
            }
            else {
                addresses = addressRepository.findByPersonId(address.getPerson().getId());
            }
            if (addresses.size()<3){
                if (address.isDefault()) {
                    for (Address address1 : addresses) {
                        if (address1.isDefault()) {
                            address1.setDefault(false);
                            addressRepository.save(address1);
                        }
                    }
                }
                return addressRepository.save(address);
            }
            else {
                throw new Exception("There are already 3 entries in DB, saving aborted.");
            }
        }
        catch (Exception e){
            throw new Exception("Error while adding Address.");
        }
    }

    public Person addPerson(Person person) throws Exception {
        try {
            Person save = personRepository.save(person);
            return save;
        }
        catch (Exception e){
            throw new Exception("Error while adding Person.");
        }
    }

    public String deleteAddress(Long id) throws Exception{
        addressRepository.deleteById(id);
        return "Deleted successfully.";
    }

    public String deletePerson(Long id) throws Exception{
        List<Address> addresses = addressRepository.findByPersonId(id);
        for (Address address: addresses){
            addressRepository.delete(address);
        }
        personRepository.deleteById(id);
        return "Deleted successfully.";
    }

    public String setDefaultAddress(Long personId, Long addressId) {
        Person person = personRepository.findById(personId).get();
        List<Address> addresses = addressRepository.findByPersonId(personId);
        String defoultAddressName = "";
        for(Address address: addresses){
            if (address.getId().equals(addressId)){
                address.setDefault(true);
                defoultAddressName = address.getNameOfAddress();
            }
            else {
                address.setDefault(false);
            }
        }
        addressRepository.saveAll(addresses);

        return "Successfully set default address " +defoultAddressName+ " to person "
                + person.getName() + " " + person.getSurname() +".";
    }
}
