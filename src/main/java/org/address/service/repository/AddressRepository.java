package org.address.service.repository;

import org.address.service.entites.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

   List<Address> findByPersonId(Long person);
}
