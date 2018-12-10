package com.mlj.tshop.service;

import com.mlj.tshop.common.exception.ManagerNotFindException;
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
    public List<Product> findAll();

    /**
     * 根据ID查询
     */
    public Manager findById(int id) throws ManagerNotFindException;
}
