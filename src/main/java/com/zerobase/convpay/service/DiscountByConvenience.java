package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;

public class DiscountByConvenience implements DiscountInterface {
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch (payRequest.getConvenienceType()) {
            case G25:
                break;
            case GU:
                break;
            case SEVEN:
                break;
        }


    }
}
