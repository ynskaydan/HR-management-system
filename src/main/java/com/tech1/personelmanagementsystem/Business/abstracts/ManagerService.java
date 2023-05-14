package com.tech1.personelmanagementsystem.Business.abstracts;

import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Entities.concretes.Employee;
import com.tech1.personelmanagementsystem.Entities.concretes.Manager;

import java.util.List;

public interface ManagerService {
    DataResult<List<Manager>> getAll();
    DataResult<List<Manager>> getAllSorted();
    DataResult<Manager> getById(int id);
    Result Add(Manager manager);

    Result Update(Manager manager);
    Result Delete(Manager manager);
}
