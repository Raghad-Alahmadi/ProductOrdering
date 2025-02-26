import java.util.*;

import java.util.concurrent.*;



public class OrderManager {

    private List<Order> orders = new ArrayList<>();

    private ExecutorService executor = Executors.newFixedThreadPool(3);



    public void placeOrder(Order order) {

        System.out.println("Placing order: " + order);

        orders.add(order);

        executor.execute(() -> processOrder(order));

    }



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



    public void shutdown() {

        executor.shutdown();

    }

}

