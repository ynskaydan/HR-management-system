package com.tech1.personelmanagementsystem.Business.abstracts;

import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Entities.concretes.Director;
import com.tech1.personelmanagementsystem.Entities.concretes.Employee;

import java.util.List;

public interface DirectorService {
    DataResult<List<Director>> getAll();
    DataResult<List<Director>> getAllSorted();
    DataResult<Director> getById(int id);
    Result Add(Director director);

    Result Update(Director director);
    Result Delete(Director director);
}
