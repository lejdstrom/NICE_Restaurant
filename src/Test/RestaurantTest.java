package Test;
import Actors.Chief;
import Actors.Kitchen;
import Actors.Room;
import Actors.Waiter;
import Utils.MyUtils;
import model.Customer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantTest {

    @Test
    public void Test(){
        List<Customer> customerList = new ArrayList<>(Arrays.asList(
                new Customer(1, MyUtils.getOrder(1, "no comment")),
                new Customer(1, MyUtils.getOrder(1, "no salt")),
                new Customer(1, MyUtils.getOrder(1, "no sugar"))
        ));

        Kitchen kitchenRef = Kitchen.getInstanceOfKitchen();
        Room roomRef = Room.getInstanceOfRoom();
        Waiter waiter = new Waiter();
        Chief chief = new Chief();

        for (Customer customer: customerList) {
            roomRef.askWaiter(customer);
        }

    }
}