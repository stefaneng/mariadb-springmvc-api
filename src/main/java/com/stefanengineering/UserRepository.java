package com.stefanengineering;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    // JPA Repository automatically creates a method that selects by first name
    Collection<User> findByFirstName(String firstName);

    Collection<User> findByLastName(String lastName);

    // Matches both first and lastname using 'And'
    Collection<User> findByFirstNameAndLastName(String firstName, String lastName);
}
