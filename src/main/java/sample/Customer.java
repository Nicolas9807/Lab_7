package sample;
/**
 * @author Stolyar Mykola
 */
public class Customer extends AbstractCustomer {

    private String surname;

    public Customer(String name, String surname, String email, Account account) {
        super(name, email, account, CustomerType.PERSON);
    }

    @Override
    public double getOverdraftDiscount() {
        return 1;
    }

    public String printCustomerDaysOverdrawn() {
        String fullName = getFullName();
        String accountDescription = "Account: IBAN: " + getAccount().getIban() + ", Days Overdrawn: " + getAccount().getDaysOverdrawn();
        return fullName + accountDescription;
    }

    private String getFullName(){
        return getName() + " " + surname + " ";
    }

    public String printCustomerMoney() {
        String fullName = getFullName();
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + getAccount().getIban() + ", Money: " + getAccount().getMoney();
        return fullName + accountDescription;
    }

    public String printCustomerAccount() {
        return "Account: IBAN: " + getAccount().getIban() + ", Money: "
                + getAccount().getMoney() + ", Account type: " + getAccount().getType();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}