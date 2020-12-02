package sample;
/**
 * @author Stolyar Mykola
 */
public abstract class AbstractCustomer {
    private String name;
    private String email;
    private Account account;
    private CustomerType customerType;

    public AbstractCustomer(String name, String email, Account account, CustomerType customerType) {
        this.name = name;
        this.email = email;
        this.account = account;
        this.customerType = customerType;
    }
    public abstract double getOverdraftDiscount();

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
