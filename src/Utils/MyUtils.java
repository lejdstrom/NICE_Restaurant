package Utils;

import model.Dish;
import model.DishType;
import model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyUtils {
    public static void MySleep(int timeToSleep){
        assert(timeToSleep > 0);
        System.out.print("...");
        int realTimeToSleep = timeToSleep * 100000;

        for (int i = 0; i < realTimeToSleep; i++);
        System.out.println();
    }

    public static List<Dish> dishList = new ArrayList<>(Arrays.asList(
            new Dish(DishType.MEAT, "Burger", 45.5f, 10),
            new Dish(DishType.STARTERS, "Chips", 25f, 5),
            new Dish(DishType.FISH, "Salmon", 100f, 8),
            new Dish(DishType.STARTERS, "Salad", 50f, 5),
            new Dish(DishType.DESSERT, "Ice Cream", 75f, 5)
    ));

    public static Order getOrder(int tableNumber, String comment){
        return new Order(dishList, tableNumber, comment);
    }
}