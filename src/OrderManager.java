import java.util.*;
import java.util.concurrent.*;



public class OrderManager {
    private List<Order> orders = new ArrayList<>(); //LIST OF ORDERS
    private ExecutorService executor = Executors.newFixedThreadPool(3); //EXECUTOR SERVICE TO HANDLE 3 THREADS


    //METHOD TO PLACE ORDER by adding order to the list and executing the processOrder method
    public void placeOrder(Order order) {
        System.out.println("Placing order: " + order);
        orders.add(order);
        executor.execute(() -> processOrder(order));

    }

    //METHOD TO PROCESS ORDER by simulating processing delay and setting the status of the order
    private void processOrder(Order order) {
        try {
            Thread.sleep(2000);  // Simulate processing delay
            order.setStatus(Order.OrderStatus.SHIPPED);
            System.out.println("Order shipped: " + order);
            Thread.sleep(2000);
            order.setStatus(Order.OrderStatus.DELIVERED);
            System.out.println("Order delivered: " + order);

        } catch (InterruptedException e) {

            System.err.println("Error processing order: " + order.getOrderId());

        }

    }
    //METHOD TO SHUTDOWN THE ORDER MANAGER by shutting down the executor service    
    public void shutdown() {

        executor.shutdown();

    }

}

