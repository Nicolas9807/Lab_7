package sample;
/**
 * @author Stolyar Mykola
 */
public class Account {

    private String iban;
    private AccountType type;
    private int daysOverdrawn;
    private AbstractCustomer customer;
    private Money money;

    public Account(AccountType type, int daysOverdrawn) {
        super();
        this.type = type;
        this.daysOverdrawn = daysOverdrawn;
    }

    public double bankcharge() {
        double result = 4.5;

        result += overdraftCharge();

        return result;
    }

    private double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10;
            if (getDaysOverdrawn() > 7)
                result += (getDaysOverdrawn() - 7) * 1.0;
            return result;
        } else
            return getDaysOverdrawn() * 1.75;
    }

    public double overdraftFee() {
        if (type.isPremium()) {
            return 0.10;
        } else {
            return 0.20;
        }
    }

    public String printAccount() {
        return "Account: IBAN: " + getIban() + ", Money: "
                + getMoney().getValue() + ", Account type: " + getType();
    }

    public String printDaysOverdrawnDescription() {
        return "Account: IBAN: " + getIban() + ", Days Overdrawn: " + getDaysOverdrawn();
    }

    public String printMoneyDescription() {
        return "Account: IBAN: " + getIban() + ", Money: " + getMoney().getValue();
    }

    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public AbstractCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(AbstractCustomer customer) {
        this.customer = customer;
    }

    public AccountType getType() {
        return type;
    }

    public String printCustomer() {
        return customer.getName() + " " + customer.getEmail();
    }
}