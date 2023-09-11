package model;
public class Customer  {
    public int tableNumber;
    public Order order;

    public Customer(int tableNumber, Order order) {
        this.tableNumber = tableNumber;
        this.order = order;
    }
}