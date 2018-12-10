package com.mlj.tshop.service.impl;

import com.mlj.tshop.common.exception.ManagerNotFindException;
import com.mlj.tshop.dao.ManagerDao;
import com.mlj.tshop.pojo.Manager;
import com.mlj.tshop.pojo.Product;
import com.mlj.tshop.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public Manager findById(int id) throws ManagerNotFindException {
        Manager manager = managerDao.selectById(id);

        System.out.println(manager);

        return manager;
    }
}
