package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayMethodType;

public class PayCancelRequest {
    //결제 수단
    PayMethodType payMethodType;

    //편의점 종류
    ConvenienceType convenienceType;

    //결제 취소 금액
    Integer PaCancelAmount;

    public PayCancelRequest(PayMethodType payMethodType, ConvenienceType convenienceType, Integer paCancelAmount) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        PaCancelAmount = paCancelAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }

    public Integer getPaCancelAmount() {
        return PaCancelAmount;
    }

    public void setPaCancelAmount(Integer paCancelAmount) {
        PaCancelAmount = paCancelAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancelAmount() {
        return PaCancelAmount;
    }

    public void setPayCancelAmount(Integer paCancelAmount) {
        PaCancelAmount = paCancelAmount;
    }
}
