# NICE_Restaurant
simulation of a restaurant

![class diagram](ClassDiagram.png)

## Restaurant flow
Room.askWaiter(Customer) -> Call Waiter.act("room") -> call Kithchen.sendOrderToChief(Customer.order) -> [preparing order ...] Chief call Kitche.sendOrderToWaiter(Order)
