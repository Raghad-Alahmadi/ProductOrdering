import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Step 1: Create products
        Product laptop = new Product("Laptop", 1200.0, 20, 5);
        Product smartphone = new Product("Smartphone", 800.0, 10, 3);


        // Step 3: Take user input for stock prediction

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter average daily sales for Laptop: ");

        int laptopSales = scanner.nextInt();

        System.out.print("Enter average daily sales for Smartphone: ");

        int smartphoneSales = scanner.nextInt();

        // Step 4: Predict stock depletion
        System.out.println(laptop);
        System.out.println("----------------------------");
        System.out.println(smartphone);
        System.out.println("----------------------------");
        StockPredictor.predictStock(laptop, laptopSales);
        StockPredictor.predictStock(smartphone, smartphoneSales);


        // Step 5: Simulate order processing
        OrderManager orderManager = new OrderManager();
        Order order1 = new Order("Raghad", laptop.getProductId(), 2);
        Order order2 = new Order("Amal", smartphone.getProductId(), 1);

        orderManager.placeOrder(order1);
        orderManager.placeOrder(order2);

        // Allow time for threads to finish
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Step 6: Shutdown the order manager
        orderManager.shutdown();
        scanner.close();
    }
}