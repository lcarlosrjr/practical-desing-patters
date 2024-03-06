package com.practical.gof.repository;

import com.practical.gof.model.Address;
import com.practical.gof.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
