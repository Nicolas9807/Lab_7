package sample;

public class CustomerOperations {
    public static void withdraw(AbstractCustomer customer, double sum, String currency) {
        Account account = customer.getAccount();
        if (!account.getMoney().getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
        withdraw(account, sum, customer.getOverdraftDiscount());
    }

    private static void withdraw(Account account, double sum, double companyOverdraftDiscount) {
        Money accountMoney = account.getMoney();
        double left = accountMoney.getValue() - sum;
        accountMoney.setValue(accountMoney.getValue() < 0
                ? left - sum * account.overdraftFee() * companyOverdraftDiscount
                : left);
    }
}
