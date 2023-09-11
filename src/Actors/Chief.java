package Actors;

import Interfaces.EventListener;
import Utils.MyUtils;
import model.Dish;
import model.Order;

public class Chief implements EventListener {

    private final Kitchen kitchenReference;

    public Chief() {
        this.kitchenReference = Kitchen.getInstanceOfKitchen();
        kitchenReference.addListener(this);
    }

    @Override
    public void act(String param) {
        if(param.equals("kitchen")){
            Order orderToBePrepared = kitchenReference.getOrdersToBePrepared().poll();
            if(orderToBePrepared != null){
                prepareOrderLOG(orderToBePrepared);
                kitchenReference.sendOrderToWaiter(orderToBePrepared);
            }else{
                System.out.println("No order to be prepared !");
            }
        }else{
            System.out.println("chief dont know what to do");
        }
    }

    public void prepareOrderLOG(Order order){
        System.out.println("Actors.Chief prepare model.Order ...");
        for (Dish dish: order.dishes) {
            System.out.println("preparing: " + dish.name);
            MyUtils.MySleep((int)dish.preparationTimeInMinute);
            System.out.println("done !");
        }
    }
}