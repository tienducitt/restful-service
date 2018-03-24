package com.eventgate.backend.service.repository;

import com.eventgate.backend.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Find users by username
     * @param username
     * @return the user with input username
     *          If no user is found, return null.
     */
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUserName(@Param("username") String username);
}
