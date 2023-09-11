package Actors;

import Interfaces.EventListener;
import Interfaces.EventPublisher;
import model.Customer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Room implements EventPublisher {
    // should be thread safe if we want multiple waiter to serve multiple customer
    private Queue<Customer> customerQueue;
    private List<EventListener> waiters;
    private static Room roomInstance = null;

    private Room(){
        customerQueue = new ArrayDeque<>();
        waiters = new ArrayList<>();
    }
    public static Room getInstanceOfRoom(){
        if(roomInstance == null){
            roomInstance = new Room();
        }
        return roomInstance;
    }

    @Override
    public void addListener(EventListener listener) {
        waiters.add(listener);
    }

    public Queue<Customer> getCustomerQueue() {
        return customerQueue;
    }

    @Override
    public void notifyListeners() {
        for (EventListener listener: waiters) {
                listener.act("room");
        }
    }

    public void askWaiter(Customer customer){
        System.out.println("Hi i want to choose some food !");
        customerQueue.add(customer);
        notifyListeners();
    }
}