package com.tech1.personelmanagementsystem.DataAccess.abstracts;
import com.tech1.personelmanagementsystem.Entities.concretes.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerDao extends JpaRepository<Manager, Integer> {
    Manager getManagersById(int id);
}
