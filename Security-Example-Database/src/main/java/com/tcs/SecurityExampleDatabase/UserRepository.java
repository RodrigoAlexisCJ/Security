package com.tcs.SecurityExampleDatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	  User findByUsernameAndDisabled(String username, boolean disabled);
	}