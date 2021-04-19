package com.heedi.spring.aop.user;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void update(User user) throws Exception;

}
