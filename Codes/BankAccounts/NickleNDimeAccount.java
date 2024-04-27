public class NickleNDimeAccount extends BankAccount {
    public NickleNDimeAccount(int intialBalance) {
        super(intialBalance);
    }
    @Override
    protected double monthlyCharge() {
        return transactionCount() * 0.5;
    }
}