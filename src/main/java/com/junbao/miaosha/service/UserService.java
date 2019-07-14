package com.junbao.miaosha.service;

import com.junbao.miaosha.dao.UserDao;
import com.junbao.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 小笨蛋
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getById(int id) {
        return userDao.getById(id);
    }

    @Transactional
    public boolean tx(){
        User user = new User();
        user.setId(2);
        user.setName("lucy");
        userDao.insert(user);
        return true;
    }
}
