package com.prodigious.deliverySystem.delivery;

import com.prodigious.deliverySystem.drons.Dron;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPlan {

    private List<Delivery> deliveries=new ArrayList<>();

    public void addDelivery(Delivery delivery){
        deliveries.add(delivery);
    }

    public void executePlan(Dron dron){
        throw new UnsupportedOperationException();
    }
}
