package model;

import lombok.Getter;
import model.Dish;

import java.util.ArrayList;
import java.util.List;
public class Order {
    // should be private
    public List<Dish> dishes;
    public int tableNumber;
    public String comment;

    public Order(List<Dish> dishes, int tableNumber, String comment) {
        this.dishes = dishes;
        this.tableNumber = tableNumber;
        this.comment = comment;
    }

    public Order(int tableNumber) {
        this.dishes = new ArrayList<>();
        this.tableNumber = tableNumber;
    }
    public void addDish(Dish dish){
        dishes.add(dish);
    }
    public void addComment(String comment){
        this.comment = comment;
    }
}