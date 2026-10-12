class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) { super(message); }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) { super(message); }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) { super(message); }
}

class Bank {
    private double balance = 1000;
    private String accountNumber = "12345";

    public void verifyAccount(String accNum) throws AccountNotFoundException {
        if (!this.accountNumber.equals(accNum)) {
            throw new AccountNotFoundException("Account not found");
        }
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class Ques5 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        try {
            bank.verifyAccount("12345");
            bank.deposit(500);
            bank.withdraw(200);
            System.out.println(bank.getBalance());
            bank.withdraw(2000); 
        } catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}