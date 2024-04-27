public abstract class BankAccount {
    double balance;
    int transaction = 0;
    public BankAccount(double intialBalance) {
        balance = intialBalance;
    }
    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        transaction++;
        balance += amount;
        return true;
    }
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        transaction++;
        balance -= amount;
        return true;
    }
    public void endMonth() {
        balance -= monthlyCharge();
        transaction = 0;
    }
    public double getBalance() {
        return balance;
    }
    public int transactionCount() {
        return transaction;
    }
    protected double monthlyCharge() {
        return 0;
    }
}