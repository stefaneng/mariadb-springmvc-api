package com.stefanengineering;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    Collection<User> findByFirstName(String firstName);

    Collection<User> findByLastName(String lastName);

    Collection<User> findByFirstNameAndLastName(String firstName, String lastName);
}
