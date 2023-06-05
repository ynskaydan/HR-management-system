package com.tech1.personelmanagementsystem.Business.concretes;

import com.tech1.personelmanagementsystem.Business.abstracts.DirectorService;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.SuccessDataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.SuccessResult;
import com.tech1.personelmanagementsystem.DataAccess.abstracts.DirectorDao;
import com.tech1.personelmanagementsystem.DataAccess.abstracts.EmployeeDao;
import com.tech1.personelmanagementsystem.Entities.concretes.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DirectorManager implements DirectorService {
    private DirectorDao directorDao;
    // private final LoggerService loggerService;
    @Autowired
    public DirectorManager(DirectorDao directorDao/*, LoggerService _loggerService*/){
        this.directorDao = directorDao;
        // this.loggerService = _loggerService;
    }
    @Override
    public DataResult<List<Director>> getAll() {
        return new SuccessDataResult<List<Director>>(this.directorDao.findAll(),"All managers listed");
    }

    @Override
    public DataResult<List<Director>> getAllSorted() {
        return null;
    }

    @Override
    public DataResult<Director> getById(int id) {
        return new SuccessDataResult<Director>(this.directorDao.getDirectorById(id),"Director is found with provided id!");
    }

    @Override
    public Result Add(Director director) {
        this.directorDao.save(director);
        return new SuccessResult("Director is added!");
    }

    @Override
    public Result Update(Director director) {
        this.directorDao.save(director);
        return new SuccessResult("Director is updated!");
    }

    @Override
    public Result Delete(Director director) {
        this.directorDao.delete(director);
        return new SuccessResult("Director is deleted!");
    }
}
