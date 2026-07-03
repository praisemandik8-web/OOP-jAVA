public class Account {
    int balance;
    private String pin;
    public int getBalance(){

        return balance;
    }

    public int deposit(int amount) {
        if(amount > 0) {
            balance = balance + amount;
        }
            return balance;
    }
    public void createPin(String newPin) {
        pin = newPin;
    }
    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }
    public int withdraw(int amount){

        if(amount > 0 && balance >= amount){
        balance = balance - amount;
        }
        return balance;

    }

}