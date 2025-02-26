public class StockPredictor {
    // Method to predict stock depletion based on average daily sales
    public static void predictStock(Product product, int dailySales) {
        int daysUntilStockOut = product.getStockLevel() / dailySales; /// Calculate days until stock out

        String suggestion;  // Suggestion based on stock level

        if (daysUntilStockOut <= product.getReorderThreshold()) { // Check if stock level is critical
            suggestion = "Critical: Restock immediately!"; // Suggest restocking
        } else if (daysUntilStockOut <= product.getReorderThreshold() * 2) { // Check if stock level is moderate
            suggestion = "Moderate: Consider restocking soon.";
        } else { // Stock level is safe
            suggestion = "Safe: No restock needed for now.";
        }

        // Print stock prediction
        System.out.println("Stock Prediction for " + product.getName() + ":");
        System.out.println("Days until stock out: " + daysUntilStockOut);
        System.out.println("Restock Suggestion: " + suggestion);
        System.out.println("----------------------------");

    }

}
