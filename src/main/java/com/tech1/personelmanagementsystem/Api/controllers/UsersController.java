package com.tech1.personelmanagementsystem.Api.controllers;

import com.tech1.personelmanagementsystem.Business.abstracts.EmployeeService;
import com.tech1.personelmanagementsystem.Business.abstracts.UserService;
import com.tech1.personelmanagementsystem.Core.Entities.User;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.*;
import com.tech1.personelmanagementsystem.Entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService){
        super();
        this.userService = userService;
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        DataResult<List<User>> result = this.userService.getAll();
        if (result.isSuccess())
            return new SuccessDataResult<>(result.getData(),result.getMessage());
        else {
            return new ErrorDataResult<>(result.getMessage());
        }

    }
    @GetMapping("/getbyusername")
    public DataResult<User> getByUserName(@RequestParam("username") String username){
        DataResult<User> result = this.userService.findByUsername(username);
        if(result.isSuccess())
            return new SuccessDataResult<>(result.getData(),result.getMessage());
        else
            return new ErrorDataResult<>(result.getMessage());
    }

    @GetMapping("/get")
    public DataResult<User> getById(int id){
        DataResult<User> result = this.userService.getById(id);
        if (result.isSuccess())
            return new SuccessDataResult<>(result.getData(),result.getMessage());
        else {
            return new ErrorDataResult<>(result.getMessage());
        }

    }

    @PostMapping("/add")
    public Result Add(@RequestBody User user){
        Result result = this.userService.Add(user);
        if (result.isSuccess()){
            return new SuccessResult(result.getMessage());
        } else
            return new ErrorResult(result.getMessage());

    }

    @PutMapping("/update")
    public Result Update(@RequestBody User user) {
        Result result = this.userService.Update(user);
        if (result.isSuccess())
            return new SuccessResult(result.getMessage());
        else
            return new ErrorResult(result.getMessage());
    }

    @DeleteMapping("/delete")
    public Result Delete(@RequestBody User user){
        Result result = this.userService.Delete(user);
        if (result.isSuccess())
            return new SuccessResult(result.getMessage());
        else
            return new ErrorResult(result.getMessage());
    }







}

