package food.utility;

import food.model.FoodOrder;
import food.service.Discountable;;

public class OrderUtility {
    public static boolean validateAmount(double amount){
        if(amount > 0){
            return true;
        }
        return false;
    }
    public static boolean validateCustomerName(String name){
        if(name != null && !name.equals("")){
            return true;
        }
        return false;
    }

    public static void generateOrderSummary(FoodOrder order, Discountable discountOrder){
        double discount = discountOrder.applyDiscount();
        double delivery = order.calculateDeliveryCharge();

        double finalAmount = order.getAmount() - discount + delivery;

        System.out.println("--------------------------------");
        System.out.println("Restaurant: " + FoodOrder.getRestaurantName());
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Bill Amount: Rs. " + order.getAmount());
        System.out.println("Discount: Rs. " + discount);
        System.out.println("Delivery Charge: Rs. " + delivery);
        System.out.println("Final Amount: Rs. " + finalAmount);
        System.out.println("--------------------------------");
    }
}
