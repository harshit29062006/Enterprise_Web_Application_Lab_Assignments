import java.util.Scanner;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String msg) { super(msg); }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String msg) { super(msg); }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String msg) { super(msg); }
}

public class Ques6 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";
    private static int failedAttempts = 0;
    private static final int MAX_ATTEMPTS = 3;
    private static boolean isLocked = false;

    public static void login(String user, String pass) throws AccountLockedException, InvalidUsernameException, InvalidPasswordException {
        if (isLocked) {
            throw new AccountLockedException("Account is locked");
        }
        if (!USERNAME.equals(user)) {
            failedAttempts++;
            checkLock();
            throw new InvalidUsernameException("Invalid username");
        }
        if (!PASSWORD.equals(pass)) {
            failedAttempts++;
            checkLock();
            throw new InvalidPasswordException("Invalid password");
        }
        System.out.println("Login successful");
        failedAttempts = 0;
    }

    private static void checkLock() throws AccountLockedException {
        if (failedAttempts >= MAX_ATTEMPTS) {
            isLocked = true;
            throw new AccountLockedException("Maximum attempts reached. Account locked.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            login(sc.next(), sc.next());
        } catch (AccountLockedException e) {
            System.out.println(e.getMessage());
        } catch (InvalidUsernameException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Login attempt processed.");
        }
    }
}