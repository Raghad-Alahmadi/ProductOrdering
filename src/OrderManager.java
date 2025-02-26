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

        System.out.println("Processing order: " + order);

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        System.out.println("Order processed: " + order);

    }



    public void shutdown() {

        executor.shutdown();

    }

}

