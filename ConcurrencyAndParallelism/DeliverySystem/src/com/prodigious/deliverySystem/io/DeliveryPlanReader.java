package com.prodigious.deliverySystem.io;

import com.prodigious.deliverySystem.delivery.Delivery;
import com.prodigious.deliverySystem.delivery.DeliveryPlan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryPlanReader {


    public static List<DeliveryPlan> initDeliveryPlans(String fileName){
        List<DeliveryPlan> planList=new ArrayList<>();
        File plansFiLe= new File(DeliveryPlanReader.class.getClassLoader().getResource(fileName).getFile());
        try(Scanner in=new Scanner(plansFiLe)){
            int dronNum=Integer.parseInt(in.nextLine());
            int dronCapacity=Integer.parseInt(in.nextLine());
            for(int i=0;i<dronNum;i++){
                DeliveryPlan plan=new DeliveryPlan();
                for(int j=0;j<dronCapacity;j++){
                    if(in.hasNextLine()){
                        Delivery delivery=initDelivery(in.nextLine());
                        plan.addDelivery(delivery);
                    }
                }
                planList.add(plan);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return planList;
    }


    private static Delivery initDelivery(String script){
        Delivery delivery=new Delivery();
        script.chars().forEach(i-> DeliveryTask.fromString(String.valueOf((char)i)).ifPresent(t->delivery.addCommand(t.getCommand())));
        return delivery;
    }
}
