package com.mlj.tshop.service;

import com.mlj.tshop.common.exception.ManagerDisableException;
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
    List<Manager> findAll();

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
    Manager login(String username, String password) throws ManagerNotExistException,
            PasswordIncorrectException, ManagerDisableException;

    /**
     * 注册
     */
    Manager register(Manager manager) throws ManagerExistException;

    /**
     * 申请一个可用ID
     */
    Integer applyForId();

    /**
     * 根据ID判断管理员账号是否可用
     * 0表示禁用
     * 1表示可用
     */
    Boolean isEnableById(int id) throws ManagerNotExistException;
}
