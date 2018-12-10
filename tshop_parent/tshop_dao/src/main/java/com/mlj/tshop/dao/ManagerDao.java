package com.mlj.tshop.dao;

import com.mlj.tshop.pojo.Manager;
import com.mlj.tshop.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2018/12/06：
 *
 * @author mlj
 */
@Mapper
public interface ManagerDao {

    /**
     * 查询所有
     */
    public List<Product> selectAll();

    /**
     * 根据id查询
     */
    public Manager selectById(@Param("id") int id);
}
