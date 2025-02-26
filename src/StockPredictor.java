public class StockPredictor {
    public static void predictStock(Product product, int dailySales) {
        int daysUntilStockOut = product.getStockLevel() / dailySales;

        String suggestion;

        if (daysUntilStockOut <= product.getReorderThreshold()) {
            suggestion = "Critical: Restock immediately!";
        } else if (daysUntilStockOut <= product.getReorderThreshold() * 2) {
            suggestion = "Moderate: Consider restocking soon.";
        } else {
            suggestion = "Safe: No restock needed for now.";
        }
        System.out.println("Stock Prediction for " + product.getName() + ":");
        System.out.println("Days until stock out: " + daysUntilStockOut);
        System.out.println("Restock Suggestion: " + suggestion);
        System.out.println("----------------------------");

    }

}