package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConveniencePayService { //편의점 결제시스템
    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap =
            new HashMap<>();
    private final DiscountInterface discountInterface;


    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                                 DiscountInterface discountInterface) {
         paymentInterfaceSet.forEach(
                 paymentInterface -> paymentInterfaceMap.put(
                         paymentInterface.getPatMethodType(),
                         paymentInterface
                 )


         );

        this.discountInterface = discountInterface;
    }

    //payrequest를 받아서
    //payresponse를 던지는는
    //결제 - 페이 리퀘스트 받기
    //편의점 금액, 결제금액을 받기
    //private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    //private final CardAdapter cardAdapter = new CardAdapter();
    //private final DiscountInterface discountInterface = new DiscountByPayMethod();
    //private final DiscountInterface discountInterface = new DiscountByConvenience();


    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface =
                paymentInterfaceMap.get(payRequest.getPayMethodType());

        Integer discountAmount = discountInterface.getDiscountedAmount(payRequest);


        //요즘 선호되는 방식은 fail fast
        //Method()
        // Exception case1
        // Exception case2
        // Exception case 3
        // Success Case(Only one) 마지막에 처리를 한다.

        PaymentResult payment = paymentInterface.payment(payRequest.getPayAmount());


        if(payment == PaymentResult.PAYMENT_FAIL) {
             return new PayResponse(PayResult.FAIL, 0);
         }

        // Success Case(Only one)
             return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());


    }

    //결제 취소
    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface =
                paymentInterfaceMap.get(payCancelRequest.getPayMethodType());


        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if(cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCLE_FAIL, 0);
        }

        //Success Case
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());


    }


}
