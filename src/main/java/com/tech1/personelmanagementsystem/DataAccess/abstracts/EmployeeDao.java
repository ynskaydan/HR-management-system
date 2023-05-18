package com.tech1.personelmanagementsystem.DataAccess.abstracts;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Entities.abstracts.EmployeeWithNames;
import com.tech1.personelmanagementsystem.Entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>{
    @Query("SELECT new com.tech1.personelmanagementsystem.Entities.abstracts.EmployeeWithNames(e.id, e.firstName, e.lastName, r.name, d.name, m.firstName) " +
            "FROM Employee e " +
            "JOIN e.region r " +
            "JOIN e.department d  " +
            "JOIN e.manager m ")
    List<EmployeeWithNames> getEmployeesDtos();
    @Query("SELECT new com.tech1.personelmanagementsystem.Entities.abstracts.EmployeeWithNames(e.id, e.firstName, e.lastName, r.name, d.name, m.firstName) " +
            "FROM Employee e " +
            "JOIN e.region r " +
            "JOIN e.department d  " +
            "JOIN e.manager m " +
            "WHERE e.id = :id"
    )
    List<EmployeeWithNames> getEmployeeDto(int id);

    /*
    Employee getByEmployeeId(int id);

    Employee getByEmployeeName(String name);
    //@Query("From Employee where managerId=:managerId ")
    List<Employee> getByManagerId(int managerId);
    //@Query("From Employee where region_id=:regionId")
    List<Employee> getByRegionId(int regionId);
    List<Employee> getByDepartmentId(int id);
    List<Employee> getByDepartmentName(String name);
    List<Employee> getByRegionName(String name);
*/




}
