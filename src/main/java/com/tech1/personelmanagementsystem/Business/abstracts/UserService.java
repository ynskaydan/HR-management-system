package com.tech1.personelmanagementsystem.Business.abstracts;

import com.tech1.personelmanagementsystem.Core.Entities.User;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;

import java.util.List;

public interface UserService {
    Result Add(User user);
    DataResult<List<User>> getAll();
    DataResult<User> getById(int id);

    DataResult<User> findByUsername(String username);
    DataResult<User> findByEmail(String email);
    Result Delete(User user);
    Result Update(User user);
    DataResult<User> checkUserExistByUsernamePassword(String username, String password);
    Result checkUserExistByUsernameEmail(String email,String password);


}
