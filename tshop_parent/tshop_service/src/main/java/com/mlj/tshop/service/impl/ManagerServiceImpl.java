package com.mlj.tshop.service.impl;

import com.mlj.tshop.common.constant.ManagerConstant;
import com.mlj.tshop.common.exception.ManagerExistException;
import com.mlj.tshop.common.exception.ManagerNotExistException;
import com.mlj.tshop.common.exception.PasswordIncorrectException;
import com.mlj.tshop.common.util.Random;
import com.mlj.tshop.dao.ManagerDao;
import com.mlj.tshop.pojo.Manager;
import com.mlj.tshop.pojo.Product;
import com.mlj.tshop.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 2018/12/06：
 *
 * @author mlj
 */
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Product> findAll() {
        return managerDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Manager findById(int id) throws ManagerNotExistException {
        Manager manager = managerDao.selectById(id);

        if (null == manager) {
            throw new ManagerNotExistException("用户\'" + id + "\'不存在！");
        }
        return manager;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Manager findByName(String name) throws ManagerNotExistException {
        Manager manager = managerDao.selectByName(name);

        if (null == manager) {
            throw new ManagerNotExistException("用户\'" + name + "\'不存在！");
        }
        return manager;
    }

    @Override
    public Manager login(String username, String password) throws ManagerNotExistException, PasswordIncorrectException {
        Manager manager = this.findByName(username);

        if (!password.equals(manager.getPassword())) {
            throw new PasswordIncorrectException("您输入的密码有误！");
        }
        return manager;
    }

    @Override
    public Manager register(Manager manager) throws ManagerExistException {
        try {
            findByName(manager.getName());
            throw new ManagerExistException("此用户名已存在！");
        } catch (ManagerNotExistException e) {
            //e.printStackTrace();
            manager.setId(applyForId());
            manager.setEnable(ManagerConstant.MANAGER_ENABLE);
            manager.setLevel(ManagerConstant.MANAGER_GENERAL);
            managerDao.insert(manager.getId(), manager.getName(), manager.getPassword(),
                    manager.getEnable(), manager.getLevel());
            return manager;
        }
    }

    @Override
    public Integer applyForId() {
        Integer id = (int) Random.getLong(ManagerConstant.ID_LENGTH);
        try {
            findById(id);
            return applyForId();
        } catch (ManagerNotExistException e) {
            e.printStackTrace();
            return id;
        }
    }
}
