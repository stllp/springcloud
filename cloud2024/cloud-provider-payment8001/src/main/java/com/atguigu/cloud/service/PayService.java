package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * @Author : 吕良平
 * @Date: 2024-09-14 16:38
 * @Description:
 */
public interface PayService {

    int add(Pay pay);

    int update(Pay pay);

    int delete(Integer id);

    Pay selectById(Integer id);

    List<Pay> selectAll();
}
