package Test.TestActors;

import Actors.Kitchen;
import Actors.Chief;
import Actors.Waiter;
import Utils.MyUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import model.Order;
import org.junit.jupiter.api.Test;

class ChiefTest {
    private static Kitchen kitchenRef = null;
    private static Chief chiefRef = null;
    private static Waiter waiterRef = null;
    private static Order order = null;

    @BeforeAll
    public static void setUp(){
        kitchenRef = Kitchen.getInstanceOfKitchen();
        chiefRef = new Chief();
        waiterRef = new Waiter();
        order = MyUtils.getOrder(12, "no comment");
    }

    @Test
    void notificationToChiefShouldRemoveOrderFromToBePreparedQueue() {
        //arrange
        //act
        kitchenRef.getOrdersToBePrepared().add(order);
        int sizeOfBePreparedQueueBeforeAct = kitchenRef.getOrdersToBePrepared().size();
        kitchenRef.notifyListeners();

        //assert
        Assertions.assertEquals(sizeOfBePreparedQueueBeforeAct - 1,
                kitchenRef.getOrdersToBePrepared().size());
    }
}