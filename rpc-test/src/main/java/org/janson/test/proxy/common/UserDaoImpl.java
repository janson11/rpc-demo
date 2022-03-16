package org.janson.test.proxy.common;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/16 19:06
 **/
public class UserDaoImpl implements UserDao {

    @Override
    public void insert() {
        System.out.println("insert user success");
    }
}
