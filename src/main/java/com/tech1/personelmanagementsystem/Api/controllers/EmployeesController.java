package com.tech1.personelmanagementsystem.Api.controllers;

import com.tech1.personelmanagementsystem.Business.abstracts.EmployeeService;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.*;
import com.tech1.personelmanagementsystem.Entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService){
        super();
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employee>> getAll(){
        DataResult<List<Employee>> result = this.employeeService.getAll();
        if (result.isSuccess())
            return new SuccessDataResult<>(result.getData(),result.getMessage());
        else {
            return new ErrorDataResult<>(result.getMessage());
        }

    }

    @GetMapping("/get")
    public DataResult<Employee> getById(int id){
        DataResult<Employee> result = this.employeeService.getById(id);
        if (result.isSuccess())
            return new SuccessDataResult<>(result.getData(),result.getMessage());
        else {
            return new ErrorDataResult<>(result.getMessage());
        }

    }

    @PostMapping("/add")
    public Result Add(@RequestBody Employee employee){
        Result result = this.employeeService.Add(employee);
        if (result.isSuccess()){
            return new SuccessResult(result.getMessage());
        } else
            return new ErrorResult(result.getMessage());

    }

    @PutMapping("/update")
    public Result Update(@RequestBody Employee employee) {
        Result result = this.employeeService.Update(employee);
        if (result.isSuccess())
            return new SuccessResult(result.getMessage());
        else
            return new ErrorResult(result.getMessage());
    }

    @DeleteMapping("/delete")
    public Result Delete(@RequestBody Employee employee){
        Result result = this.employeeService.Delete(employee);
        if (result.isSuccess())
            return new SuccessResult(result.getMessage());
        else
            return new ErrorResult(result.getMessage());
    }







}

