package sample;
/**
 * author Stolyar Mykola
 */
public class Customer {

    private String name;
    private String surname;
    private String email;
    private CustomerType customerType;
    private Account account;
    private double companyOverdraftDiscount = 1;

    public Customer(String name, String surname, String email, CustomerType customerType, Account account) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.customerType = customerType;
        this.account = account;
    }

    // use only to create companies
    public Customer(String name, String email, Account account, double companyOverdraftDiscount) {
        this.name = name;
        this.email = email;
        this.customerType = CustomerType.COMPANY;
        this.account = account;
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public void withdraw(double sum, String currency) {
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
        withdraw(sum, companyOverdraftDiscount / (account.getType().isPremium() ? 2 : 1));
    }

    private void withdraw(double sum, double companyOverdraftDiscount) {

        if (customerType == CustomerType.PERSON) {
            companyOverdraftDiscount = 1;
        }

        double left = account.getMoney() - sum;

        // we are in overdraft
        // 50 percent discount for overdraft for premium account
        // no discount for overdraft and not premium account
        account.setMoney(account.getMoney() < 0
                ? left - sum * account.overdraftFee() * companyOverdraftDiscount
                : left);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String printCustomerDaysOverdrawn() {
        String fullName = getFullName();

        String accountDescription = "Account: IBAN: " + account.getIban() + ", Days Overdrawn: " + account.getDaysOverdrawn();
        return fullName + accountDescription;
    }

    private String getFullName(){
        return  name + " " + surname + " ";
    }

    public String printCustomerMoney() {
        String fullName = getFullName();
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + account.getIban() + ", Money: " + account.getMoney();
        return fullName + accountDescription;
    }

    public String printCustomerAccount() {
        return "Account: IBAN: " + account.getIban() + ", Money: "
                + account.getMoney() + ", Account type: " + account.getType();
    }
}