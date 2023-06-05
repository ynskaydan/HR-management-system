package com.tech1.personelmanagementsystem.Business.concretes;
import com.tech1.personelmanagementsystem.Business.abstracts.EmployeeService;
import com.tech1.personelmanagementsystem.Core.Utilities.Logger.abstracts.LoggerService;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.*;
import com.tech1.personelmanagementsystem.DataAccess.abstracts.EmployeeDao;
import com.tech1.personelmanagementsystem.Entities.abstracts.EmployeeWithNames;
import com.tech1.personelmanagementsystem.Entities.concretes.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
   // private final LoggerService loggerService;
    @Autowired
    public EmployeeManager(EmployeeDao employeeDao/*, LoggerService _loggerService*/){
        this.employeeDao = employeeDao;
       // this.loggerService = _loggerService;
    }

    @Override
    public DataResult<List<EmployeeWithNames>> getEmployeesDtos() {
        List<EmployeeWithNames> emp = employeeDao.getEmployeesDtos();
        if (emp == null){
            return new ErrorDataResult<>("Employee data is null");
        }
        return new SuccessDataResult<>(emp,"Employee Data found!");
    }

    @Override
    public DataResult<EmployeeWithNames> getEmployeeDto(int id) {
        EmployeeWithNames emp = (EmployeeWithNames) this.employeeDao.getEmployeeDto(id);
        if(emp == null){
            return new ErrorDataResult<>("Employee data is null");
        }
        else
            return new SuccessDataResult<>(emp,"Employee Data found!");
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        //loggerService.logToSystemInfo("All Items covered");
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"All Employees Listed!");

    }

    @Override
    public DataResult<List<Employee>> getAllSorted() {
        return null;
    }



    @Override
    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<Employee>(this.employeeDao.getEmployeesById(id),"Found employee in provided id!");
    }

    @Override
    public Result Add(Employee employee) {
        String message = "Employee Added: "+ employee.getId();
        //this.loggerService.logToSystemInfo(message);
        this.employeeDao.save(employee);
        return new Result(true,message);
    }

    @Override
    public Result Update(Employee employee) {
        String message = "Employee Updated with + " + employee.getId();
        employeeDao.save(employee);
        return new SuccessResult(message);
    }

    @Override
    public Result Delete(Employee employee) {
        String message = "Employee Deleted: " + employee.getFirstName();
        this.employeeDao.delete(employee);
        return new SuccessResult(message);
    }

}
