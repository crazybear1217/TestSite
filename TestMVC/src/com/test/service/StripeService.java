package com.test.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class StripeService {

    public String stripeTest() {
    	int amount = 10000;
        Stripe.apiKey = "sk_test_WQoyzVFimDYi5Aa7N2Uav6Ns";
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", amount);
        chargeMap.put("currency", "usd");
        Map<String, Object> cardMap = new HashMap<String, Object>();
        cardMap.put("number", "4242424242424242");
        cardMap.put("exp_month", 12);
        cardMap.put("exp_year", 2020);
        chargeMap.put("card", cardMap);
        StringBuilder result = new StringBuilder();
        try {
            Charge charge = Charge.create(chargeMap);
            System.out.println(charge);
            result.append(charge);
            
        } catch (StripeException e) {
            e.printStackTrace();
        }
        
        return result.toString();
    }
}