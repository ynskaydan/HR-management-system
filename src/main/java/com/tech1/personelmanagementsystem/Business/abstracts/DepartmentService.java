package com.tech1.personelmanagementsystem.Business.abstracts;

import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Entities.concretes.Department;
import com.tech1.personelmanagementsystem.Entities.concretes.Employee;

import java.util.List;

public interface DepartmentService {
    DataResult<List<Department>> getAll();
    DataResult<List<Department>> getAllSorted();
    DataResult<Department> getById(int id);
    Result Add(Department department);

    Result Update(Department department);
    Result Delete(Department department);
}
