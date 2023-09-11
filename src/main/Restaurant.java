package main;

import Actors.Chief;
import Actors.Kitchen;
import Actors.Room;
import Actors.Waiter;
import Utils.MyUtils;

public class Restaurant {
    private Kitchen kitchen;

    // could be a collection of waiter
    private Waiter waiter;
    private Chief chief;
    private Room room;

    public Restaurant(){
        kitchen = Kitchen.getInstanceOfKitchen();
        waiter = new Waiter();
        chief = new Chief();
        room = Room.getInstanceOfRoom();
    }

    public void runRestaurant(){
        this.waiter.takeOrder(MyUtils.getOrder(1, "without ketchup"));
    }
}
