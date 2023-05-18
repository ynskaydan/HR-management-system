package com.tech1.personelmanagementsystem.Business.abstracts;




import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Entities.abstracts.EmployeeWithNames;
import com.tech1.personelmanagementsystem.Entities.concretes.Employee;

import javax.xml.crypto.Data;
import java.util.List;

public interface EmployeeService {
    DataResult<List<EmployeeWithNames>> getEmployeesDtos();
    DataResult<EmployeeWithNames> getEmployeeDto(int id);
    DataResult<List<Employee>> getAll();
    DataResult<List<Employee>> getAllSorted();
    DataResult<Employee> getById(int id);
    Result Add(Employee Employee);

    Result Update(Employee employee);
    Result Delete(Employee employee);


}
