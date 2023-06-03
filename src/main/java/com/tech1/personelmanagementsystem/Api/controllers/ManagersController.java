package com.tech1.personelmanagementsystem.Api.controllers;

import com.tech1.personelmanagementsystem.Business.abstracts.ManagerService;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.*;
import com.tech1.personelmanagementsystem.Entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/managers")
@CrossOrigin(origins = "http://localhost:5173")
public class ManagersController {

    private ManagerService managerService;

    @Autowired
    public ManagersController(ManagerService managerService){
        super();
        this.managerService = managerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Manager>> getAll(){
        DataResult<List<Manager>> result = this.managerService.getAll();
        if (result.isSuccess())
            return new SuccessDataResult<>(result.getData(),result.getMessage());
        else {
            return new ErrorDataResult<>(result.getMessage());
        }

    }

    @GetMapping("/get")
    public DataResult<Manager> getById(int id){
        DataResult<Manager> result = this.managerService.getById(id);
        if (result.isSuccess())
            return new SuccessDataResult<>(result.getData(),result.getMessage());
        else {
            return new ErrorDataResult<>(result.getMessage());
        }

    }

    @PostMapping("/add")
    public Result Add(@RequestBody Manager manager){
        Result result = this.managerService.Add(manager);
        if (result.isSuccess()){
            return new SuccessResult(result.getMessage());
        } else
            return new ErrorResult(result.getMessage());

    }

    @PutMapping("/update")
    public Result Update(@RequestBody Manager manager) {
        Result result = this.managerService.Update(manager);
        if (result.isSuccess())
            return new SuccessResult(result.getMessage());
        else
            return new ErrorResult(result.getMessage());
    }

    @DeleteMapping("/delete")
    public Result Delete(@RequestBody Manager manager){
        Result result = this.managerService.Delete(manager);
        if (result.isSuccess())
            return new SuccessResult(result.getMessage());
        else
            return new ErrorResult(result.getMessage());
    }







}

