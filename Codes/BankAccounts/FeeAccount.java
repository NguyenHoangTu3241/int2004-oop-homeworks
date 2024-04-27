public class FeeAccount extends BankAccount{
    public FeeAccount(int intialBalance) {
        super(intialBalance);
    }
    @Override
    protected double monthlyCharge() {
        return 5.00;
    }
}