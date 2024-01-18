// Pair Programmed with megan

package com.jacob.loginandreg.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jacob.loginandreg.models.User;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
