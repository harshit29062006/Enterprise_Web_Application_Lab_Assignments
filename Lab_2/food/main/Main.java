package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.utility.OrderUtility;

public class Main {

    public static void main(String[] args) {

        FoodOrder[] orders = new FoodOrder[6];

        RegularOrder order1 =
                new RegularOrder(101, "Harshit", 1799);

        PremiumOrder order2 =
                new PremiumOrder(102, "Ram", 1999);

        RegularOrder order3 =
                new RegularOrder(103, "Aman", 1500);

        PremiumOrder order4 =
                new PremiumOrder(104, "Priyam", 2200);

        RegularOrder order5 =
                new RegularOrder(105, "Mani", 800);

        PremiumOrder order6 =
                new PremiumOrder(106, "Arnav", 3000);

        orders[0] = order1;
        orders[1] = order2;
        orders[2] = order3;
        orders[3] = order4;
        orders[4] = order5;
        orders[5] = order6;

        for (int i = 0; i < 6; i++) {

            if (OrderUtility.validateAmount(
                    orders[i].getAmount()) == false) {

                System.out.println("Invalid Amount");
                continue;
            }

            if (OrderUtility.validateCustomerName(
                    orders[i].getCustomerName()) == false) {

                System.out.println("Invalid Customer Name");
                continue;
            }

            if (orders[i] == order1) {

                OrderUtility.generateOrderSummary(
                        orders[i], order1);

            } else if (orders[i] == order2) {

                OrderUtility.generateOrderSummary(
                        orders[i], order2);

            } else if (orders[i] == order3) {

                OrderUtility.generateOrderSummary(
                        orders[i], order3);

            } else if (orders[i] == order4) {

                OrderUtility.generateOrderSummary(
                        orders[i], order4);

            } else if (orders[i] == order5) {

                OrderUtility.generateOrderSummary(
                        orders[i], order5);

            } else if (orders[i] == order6) {

                OrderUtility.generateOrderSummary(
                        orders[i], order6);
            }
        }

        FoodOrder.displayTotalOrders();
    }
}