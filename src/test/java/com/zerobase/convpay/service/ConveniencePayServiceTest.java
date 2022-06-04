package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService();

    @Test
    void pay_success(){
        //given
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 50);

        //when
        //con이 pay리퀘스트를 준다.
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        //then //보증한다.
        assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
        assertEquals(50,payResponse.getPaidAmount());
    }


    @Test
    void pay_fail(){
        //given
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000_001);

        //when
        //con이 pay리퀘스트를 준다.
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        //then //보증한다.
        assertEquals(PayResult.FAIL, payResponse.getPayResult());
        assertEquals(0,payResponse.getPaidAmount());
    }


    @Test
    void pay_cancel_success(){
        //given
       PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);

        //when
        //con이 pay리퀘스트를 준다.
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        //then //보증한다.
        assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelResponse.getPayCancelResult());
        assertEquals(1000,payCancelResponse.getPayCanceledAmount());
    }


    @Test
    void pay_cancel_fail(){
        //given
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 99);

        //when
        //con이 pay리퀘스트를 준다.
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        //then //보증한다.
        assertEquals(PayCancelResult.PAY_CANCLE_FAIL, payCancelResponse.getPayCancelResult());
        assertEquals(0,payCancelResponse.getPayCanceledAmount());
    }



}