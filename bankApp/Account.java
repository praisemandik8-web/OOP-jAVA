public class Account {

    private String name;
    private int balance;
    private String pin;
    private int number;

    public Account(String name, int number, String pin) {
        this.name = name;
        this.number = number;
        this.pin = pin;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void deposit(int amount) throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero.");
        }

        balance += amount;
    }

    public void withdraw(int amount, String enteredPin)
            throws InvalidAmountException,
            InvalidPinException,
            InsufficientFundsException {

        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero.");
        }

        if (!pin.equals(enteredPin)) {
            throw new InvalidPinException("Invalid PIN.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds.");
        }

        balance -= amount;
    }

    public int checkBalance(String enteredPin)
            throws InvalidPinException {

        if (!pin.equals(enteredPin)) {
            throw new InvalidPinException("Invalid PIN.");
        }

        return balance;
    }
}