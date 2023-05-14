package com.tech1.personelmanagementsystem.Business.concretes;

import com.tech1.personelmanagementsystem.Business.abstracts.DepartmentService;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Entities.concretes.Department;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentManager implements DepartmentService {
    @Override
    public DataResult<List<Department>> getAll() {
        return null;
    }

    @Override
    public DataResult<List<Department>> getAllSorted() {
        return null;
    }

    @Override
    public DataResult<Department> getById(int id) {
        return null;
    }

    @Override
    public Result Add(Department department) {
        return null;
    }

    @Override
    public Result Update(Department department) {
        return null;
    }

    @Override
    public Result Delete(Department department) {
        return null;
    }
}
