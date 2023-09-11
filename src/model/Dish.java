package model;

public class Dish {
    DishType dishType;
    public String name;
    public float price;
    public float preparationTimeInMinute;
    public Dish(DishType dishType, String name, float price, float preparationTimeInMinute) {
        this.dishType = dishType;
        this.name = name;
        this.price = price;
        this.preparationTimeInMinute = preparationTimeInMinute;
    }
    public Dish() {}
}