package com.tech1.personelmanagementsystem.Business.concretes;
import com.tech1.personelmanagementsystem.Business.abstracts.ManagerService;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.SuccessDataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.SuccessResult;
import com.tech1.personelmanagementsystem.DataAccess.abstracts.ManagerDao;
import com.tech1.personelmanagementsystem.Entities.concretes.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagerManager implements ManagerService {
    private ManagerDao managerDao;
    // private final LoggerService loggerService;
    @Autowired
    public ManagerManager(ManagerDao managerDao/*, LoggerService _loggerService*/){
        this.managerDao = managerDao;
        // this.loggerService = _loggerService;
    }
    @Override
    public DataResult<List<Manager>> getAll() {
        //loggerService.logToSystemInfo("All Items covered");
        return new SuccessDataResult<List<Manager>>(managerDao.findAll(),"All managers Listed!");

    }

    @Override
    public DataResult<List<Manager>> getAllSorted() {
        return null;
    }

    @Override
    public DataResult<Manager> getById(int id) {
        return new SuccessDataResult<Manager>(this.managerDao.getReferenceById(id),"All Employees Listed!");
    }

    @Override
    public Result Add(Manager manager) {
        String message = "Manager Added: "+ manager.getManager_id();
        //this.loggerService.logToSystemInfo(message);
        this.managerDao.save(manager);
        return new Result(true,message);
    }

    @Override
    public Result Update(Manager manager) {
        String message = "Manager Updated with + " + manager.getFirstName();
        managerDao.save(manager);
        return new SuccessResult(message);
    }

    @Override
    public Result Delete(Manager manager) {
        String message = "Employee Deleted: " + manager.getFirstName();
        this.managerDao.delete(manager);
        return new SuccessResult(message);
    }
}
