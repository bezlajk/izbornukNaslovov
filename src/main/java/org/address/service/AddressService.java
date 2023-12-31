package org.address.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.address.service.entites.Address;
import org.address.service.entites.Person;
import org.address.service.entites.Post;
import org.address.service.repository.AddressRepository;
import org.address.service.repository.PersonRepository;
import org.address.service.repository.PostRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AddressService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final PostRepository postRepository;

    public AddressService(AddressRepository addressRepository, PersonRepository personRepository, PostRepository postRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
        this.postRepository = postRepository;
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

        List<Address> addresses = new ArrayList<>();
        if (address.getPerson().getId()==null){
            Person person = personRepository.save(address.getPerson());
            address.setPerson(person);
        }
        Optional<Post> post = postRepository.findById(address.getPost().getId());
        if ( post.isEmpty() ){
            Post postNew = postRepository.save(address.getPost());
            address.setPost(postNew);
        }
        else {
            addresses = addressRepository.findByPersonId(address.getPerson().getId());
        }
        if (addresses.size()<3){
            if (isDuplicate(addresses, address)){
                throw new Exception("These address already exists for these person.");
            }
            if (verifyName(address, addresses)){
                throw new Exception("Address name already exists for these person.");
            }
            if (address.isDefault()) {
                setAllToAngefault(addresses);
            }
            return addressRepository.save(address);
        }
        else {
            throw new Exception("There are already 3 entries in DB, saving aborted.");
        }
    }

    private boolean isDuplicate(List<Address> addresses, Address address){
        for (Address addressExisting: addresses){
            if (addressExisting.equals(address)){
                return true;
            }
        }
        return false;
    }

    private void setAllToAngefault(List<Address> addresses){
        for (Address addressExisting : addresses) {
            if (addressExisting.isDefault()) {
                addressExisting.setDefault(false);
                addressRepository.save(addressExisting);
            }
        }
    }
    private boolean verifyName(Address address, List<Address> addresses){
        for (Address addressExisting : addresses) {
            if (addressExisting.getNameOfAddress().equalsIgnoreCase(address.getNameOfAddress())){
                return true;
            }
        }
        return false;
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
