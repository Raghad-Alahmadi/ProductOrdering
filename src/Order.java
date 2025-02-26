import java.util.UUID;
 
public class Order {
    public enum OrderStatus { //ENUMERATION FOR ORDER STATUS
        PENDING,
        SHIPPED,
        DELIVERED
    }
    // VARIABLES
    private UUID orderId;
    private String customerName;
    private UUID productId;
    private int quantity;
    private OrderStatus status;

    //CONSTRUCTOR
    public Order(String customerName, UUID productId, int quantity) {
        this.orderId = UUID.randomUUID();
        this.customerName = customerName;
        this.productId = productId;
        this.quantity = quantity;
        this.status = OrderStatus.PENDING;
    }
    //GETTERS
    public UUID getOrderId() {
        return orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public UUID getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public OrderStatus getStatus() {
        return status;
    }
    //SETTERS
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    //TO PRINT OUT THE PRODUCT
    @Override
    public String toString() {
        return "Order ID: " + orderId +
                "\nCustomer: " + customerName +
                "\nProduct ID: " + productId +
                "\nQuantity: " + quantity +
                "\nStatus: " + status + "\n";
    }
}

