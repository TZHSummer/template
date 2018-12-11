package com.mlj.tshop.service;

import com.mlj.tshop.common.exception.ManagerExistException;
import com.mlj.tshop.common.exception.ManagerNotExistException;
import com.mlj.tshop.common.exception.PasswordIncorrectException;
import com.mlj.tshop.pojo.Manager;
import com.mlj.tshop.pojo.Product;

import java.util.List;

/**
 * 2018/12/06：
 *
 * @author mlj
 */
public interface ManagerService {
    /**
     * 查询所有
     */
    List<Product> findAll();

    /**
     * 根据ID查询
     */
    Manager findById(int id) throws ManagerNotExistException;

    /**
     * 根据NAME查询
     */
    Manager findByName(String name) throws ManagerNotExistException;


    /**
     * 登录
     */
    Manager login(String username, String password) throws ManagerNotExistException, PasswordIncorrectException;

    /**
     * 注册
     */
    Manager register(Manager manager) throws ManagerExistException;

    /**
     * 申请一个可用ID
     */
    Integer applyForId();
}
