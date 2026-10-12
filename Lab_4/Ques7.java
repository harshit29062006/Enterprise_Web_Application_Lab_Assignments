class ApplicationException extends Exception {
    public ApplicationException(String msg) { super(msg); }
}
class ProductException extends ApplicationException {
    public ProductException(String msg) { super(msg); }
}
class ProductNotFoundException extends ProductException {
    public ProductNotFoundException(String msg) { super(msg); }
}
class OutOfStockException extends ProductException {
    public OutOfStockException(String msg) { super(msg); }
}
class PaymentException extends ApplicationException {
    public PaymentException(String msg) { super(msg); }
}
class InvalidPaymentException extends PaymentException {
    public InvalidPaymentException(String msg) { super(msg); }
}
class InsufficientFundsException extends PaymentException {
    public InsufficientFundsException(String msg) { super(msg); }
}
class OrderException extends ApplicationException {
    public OrderException(String msg) { super(msg); }
}
class EmptyCartException extends OrderException {
    public EmptyCartException(String msg) { super(msg); }
}

public class Ques7 {
    private int cartItems = 0;
    private int stock = 5;
    private double balance = 100.0;

    public void searchProduct(boolean found) throws ProductNotFoundException {
        if (!found) throw new ProductNotFoundException("Product not found");
    }

    public void addProduct() throws OutOfStockException {
        if (stock <= 0) throw new OutOfStockException("Out of stock");
        cartItems++;
        stock--;
    }

    public void checkout(double price) throws EmptyCartException, InvalidPaymentException, InsufficientFundsException {
        if (cartItems == 0) throw new EmptyCartException("Cart is empty");
        if (price <= 0) throw new InvalidPaymentException("Invalid payment amount");
        if (price > balance) throw new InsufficientFundsException("Insufficient funds");
        balance -= price;
        cartItems = 0;
    }

    public static void main(String[] args) {
        Ques7 app = new Ques7();
        try {
            app.searchProduct(true);
            app.addProduct();
            app.checkout(50.0);
            app.checkout(200.0);
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        }
    }
}