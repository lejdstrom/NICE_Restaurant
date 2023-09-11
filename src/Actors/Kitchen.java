package Actors;

import Interfaces.EventListener;
import Interfaces.EventPublisher;
import model.Order;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Kitchen implements EventPublisher {
    private Queue<Order> ordersToBePrepared;
    private Queue<Order> ordersReady;
    private static Kitchen kitchenInstance = null;

    // should return only One order ! to keep the encapsulation
    public Queue<Order> getOrdersToBePrepared() {
        return ordersToBePrepared;
    }

    public Queue<Order> getOrdersReady() {
        return ordersReady;
    }

    private List<EventListener> listeners;

    private Kitchen(){
        this.ordersReady = new ArrayDeque<>();
        this.ordersToBePrepared = new ArrayDeque<>();
        this.listeners = new ArrayList<>();
    }
    public static Kitchen getInstanceOfKitchen(){
        if(kitchenInstance == null){
            kitchenInstance = new Kitchen();
        }
        return kitchenInstance;
    }
    @Override
    public void addListener(EventListener listener){
        listeners.add(listener);
    }
    @Override
    public void notifyListeners() {
        for (EventListener listener: listeners) {
            listener.act("kitchen");
        }
    }

    public void sendOrderToChief(Order order){
        System.out.println("sending order to chief");
        ordersToBePrepared.add(order);
        notifyListeners();
    }

    public void sendOrderToWaiter(Order order){
        System.out.println("order ready, send to waiter");
        ordersReady.add(order);
        notifyListeners();
    }
}