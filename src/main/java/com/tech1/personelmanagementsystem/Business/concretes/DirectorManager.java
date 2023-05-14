package com.tech1.personelmanagementsystem.Business.concretes;

import com.tech1.personelmanagementsystem.Business.abstracts.DirectorService;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Entities.concretes.Director;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DirectorManager implements DirectorService {
    @Override
    public DataResult<List<Director>> getAll() {
        return null;
    }

    @Override
    public DataResult<List<Director>> getAllSorted() {
        return null;
    }

    @Override
    public DataResult<Director> getById(int id) {
        return null;
    }

    @Override
    public Result Add(Director director) {
        return null;
    }

    @Override
    public Result Update(Director director) {
        return null;
    }

    @Override
    public Result Delete(Director director) {
        return null;
    }
}
