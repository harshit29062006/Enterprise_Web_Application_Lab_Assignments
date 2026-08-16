package food.model;

public abstract class FoodOrder {
    private int orderId;
    private String customerName;
    private double amount;

    private static String restaurantName = "FoodNSoul";
    static int totalOrders = 0;

    public FoodOrder(int orderId, String customerName, double amount){
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;

        totalOrders++;
    }

    public int getOrderId(){
        return orderId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public double getAmount(){
        return amount;
    }
    public static String getRestaurantName() {
    return restaurantName;
    }

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public static void displayTotalOrders(){
        System.out.println("Total Orders: " + totalOrders);
    }
    public abstract double calculateDeliveryCharge();
}
