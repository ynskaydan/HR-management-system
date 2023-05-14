package com.tech1.personelmanagementsystem.DataAccess.abstracts;
import com.tech1.personelmanagementsystem.Entities.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
