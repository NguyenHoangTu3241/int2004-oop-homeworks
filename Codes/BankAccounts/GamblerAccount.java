public class GamblerAccount extends BankAccount {
    public GamblerAccount(int intialBalance) {
        super(intialBalance);
    }
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (Math.random() < 0.51) balance -= amount * 2;
        transaction++;
        return true;
    }
}