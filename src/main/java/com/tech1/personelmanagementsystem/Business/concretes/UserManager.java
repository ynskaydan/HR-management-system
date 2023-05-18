package com.tech1.personelmanagementsystem.Business.concretes;

import com.tech1.personelmanagementsystem.Business.abstracts.UserService;
import com.tech1.personelmanagementsystem.Core.DataAccess.UserDao;
import com.tech1.personelmanagementsystem.Core.Entities.User;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result Add(User user) {
        userDao.save(user);
        return new SuccessResult("User Added");
    }

    @Override
    public DataResult<List<User>> getAll() {
        List<User> list = userDao.findAll();
        return new SuccessDataResult<>(list,"All users listed!");
    }

    @Override
    public DataResult<User> getById(int id) {
        User user = userDao.getUserById(id);
        if(user == null){
            return new ErrorDataResult<>("User not found");
        }
        return new SuccessDataResult<>(user,"User found " + user.getUsername());

    }

    public Result Delete(User user){
        String message = "User Deleted: " + user.getEmail();
        userDao.delete(user);
        return new SuccessResult(message);
    }

    @Override
    public Result Update(User user) {
        String message = "User Updated: " + user.getUsername();
        userDao.save(user);
        return new SuccessResult(message);
    }




    @Override
    public DataResult<User> checkUserExistByUsernamePassword(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user == null){
            return new ErrorDataResult<>( "User not found");
        }

        if(user.getPassword().equals(password)){
            return new SuccessDataResult<>(user,"User exist with this username,password");
        }
        return new ErrorDataResult<>("Not exist");
    }

    @Override
    public DataResult<User> checkUserExistByUsernameEmail(String email, String password) {
        return null;
    }



    @Override
    public DataResult<User> findByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        if (user == null){
            return new ErrorDataResult<>("User not found!");
        }
        return new SuccessDataResult<>(user,"User found, " + username);
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getUserByEmail(email)
                ,"User found");
    }
}
