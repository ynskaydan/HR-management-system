package com.tech1.personelmanagementsystem.Business.abstracts;

import com.tech1.personelmanagementsystem.Core.Entities.User;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;

public interface UserService {
    Result Add(User user);
    DataResult<User> findByUsername(String username);
    DataResult<User> findByEmail(String email);
    Result Delete(User user);
    Result Update(User user);
    Result checkUserExistByUsernamePassword(String username, String password);
    Result checkUserExistByUsernameEmail(String email,String password);


}
