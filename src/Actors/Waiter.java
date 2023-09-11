package Actors;

import Interfaces.EventListener;
import Utils.MyUtils;
import model.Customer;
import model.Dish;
import model.Order;

import java.util.List;

public class Waiter implements EventListener {
    public Waiter() {
        Kitchen.getInstanceOfKitchen().addListener(this);
        Room.getInstanceOfRoom().addListener(this);
    }

    @Override
    public void act(String param) {
        switch (param){
            case "room":
                Customer customer = Room.getInstanceOfRoom().getCustomerQueue().poll();
                if(customer != null){
                    Kitchen.getInstanceOfKitchen().sendOrderToChief(customer.order);
                }else{
                    System.out.println("No customer yet");
                }
                break;

            case "kitchen":
                Order orderReady = Kitchen.getInstanceOfKitchen().getOrdersReady().poll();
                if(orderReady != null){
                    serveOrderLOG(orderReady);
                }else{
                    System.out.println("No order ready !");
                }
                break;

                default:
                    System.out.println("waiter dont know what to do");
        }
    }

    public void takeOrders(List<Order> orders){
        for (Order order: orders) {
            takeOrderLog();
            Kitchen.getInstanceOfKitchen().sendOrderToChief(order);
        }
    }

    public void takeOrder(Order order){
        takeOrderLog();
        Kitchen.getInstanceOfKitchen().sendOrderToChief(order);
    }

    public void takeOrderLog(){
        System.out.println("\ttaking order");
        MyUtils.MySleep(30);
    }
    public void serveOrderLOG(Order order){
        System.out.println("\twaiter server order");
        System.out.println("\ttable number " + order.tableNumber);
        System.out.println("\tyour comment " + order.comment);
        for (Dish dish: order.dishes) {
            System.out.println("\tserving: " + dish.name);
            MyUtils.MySleep((int)dish.preparationTimeInMinute);
            System.out.println("\tdone !");
        }
    }
}