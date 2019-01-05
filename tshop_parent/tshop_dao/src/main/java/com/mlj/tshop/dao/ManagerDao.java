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
    public List<Manager> selectAll();

    /**
     * 根据id查询
     */
    public Manager selectById(@Param("id") int id);

    /**
     * 根据name查询
     */
    public Manager selectByName(@Param("name") String name);

    /**
     * 添加数据
     */
    public int insert(@Param("id") Integer id, @Param("name") String name, @Param("password") String password,
                      @Param("enable") Integer enable, @Param("level") Integer level);
}
