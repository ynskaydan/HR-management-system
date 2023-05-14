
package com.tech1.personelmanagementsystem.Core.DataAccess;

import com.tech1.personelmanagementsystem.Core.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}

