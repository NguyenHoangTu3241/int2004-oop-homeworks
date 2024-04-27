public class AccountSort {
    public interface MyComparator {
        public boolean less(BankAccount a1, BankAccount a2);
    }

    public class BalanceAscending implements MyComparator {
        @Override
        public boolean less(BankAccount a1, BankAccount a2) {
            return a1.getBalance() < a2.getBalance();
        }
    }
    public class BalanceDescending implements MyComparator {
        @Override
        public boolean less(BankAccount a1, BankAccount a2) {
            return a1.getBalance() >= a2.getBalance();
        }
    }
    public class TransactionCountDescending implements MyComparator {
        @Override
        public boolean less(BankAccount a1, BankAccount a2) {
            return a1.transactionCount() >= a2.transactionCount();
        }
    }
    public void sort(BankAccount[] account, MyComparator compare) {
        for (int i = 1; i < account.length; i++) {
            int j = i;
            while (j > 0 && compare.less(account[j], account[j - 1])) {
                BankAccount tmp = account[j];
                account[j] = account[j - 1];
                account[j - 1] = tmp;
                j--;
            }
        }
    }

}