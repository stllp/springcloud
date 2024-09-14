package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : 吕良平
 * @Date: 2024-09-14 16:47
 * @Description:
 */
@RestController
@Slf4j
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    public String addPay(@RequestBody Pay pay) {
        System.out.println("pay = " + pay);
        int add = payService.add(pay);
        return "成功插入记录，返回值：" + add;
    }

    @DeleteMapping("/pay/del/{id}")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.delete(id);
    }

    @PutMapping("/pay/update")
    public String updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int update = payService.update(pay);
        return "成功修改记录，返回值：" + update;
    }

    @GetMapping("/pay/get/{id}")
    public PayDTO selectById(@PathVariable("id") Integer id) {
        PayDTO payDTO = new PayDTO();
        Pay pay = payService.selectById(id);
        BeanUtils.copyProperties(pay, payDTO);
        return payDTO;
    }

    @GetMapping("/pay/getall")
    public List<PayDTO> selectAll() {
        List<PayDTO> payDTOList = new ArrayList<>();
        List<Pay> payList = payService.selectAll();
        BeanUtils.copyProperties(payList, payDTOList);
        return payDTOList;
    }

}
