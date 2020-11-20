package com.zhiyu.pay.service;

import com.zhiyu.pay.entity.dto.PayDTO;

/**
 * @author wengzhiyu
 * @date 2020/11/17
 */
public interface PayService {


    /**
     * 发起支付
     *
     * @param payDTO
     * @return
     */
    String payStart(PayDTO payDTO);
}
