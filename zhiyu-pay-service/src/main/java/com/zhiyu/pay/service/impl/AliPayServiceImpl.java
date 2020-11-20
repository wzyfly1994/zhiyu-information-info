package com.zhiyu.pay.service.impl;

import com.zhiyu.pay.entity.dto.PayDTO;
import com.zhiyu.pay.service.PayService;
import org.springframework.stereotype.Service;

/**
 * @author wengzhiyu
 * @date 2020/11/17
 */
@Service
public class AliPayServiceImpl implements PayService {
    @Override
    public String payStart(PayDTO payDTO) {
        return "AliPay";
    }
}
