package com.tech1.personelmanagementsystem.DataAccess.abstracts;

import com.tech1.personelmanagementsystem.Entities.concretes.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorDao extends JpaRepository<Director, Integer> {
    Director getDirectorById(int id);

}