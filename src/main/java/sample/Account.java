package sample;
/**
 * @author Stolyar Mykola
 */
public class Account {

    private String iban;
    private int daysOverdrawn;
    private AbstractCustomer customer;
    private Money money;
    private boolean premium;

    public Account(boolean premium, int daysOverdrawn) {
        super();
        this.premium = premium;
        this.daysOverdrawn = daysOverdrawn;
    }

    public double bankcharge() {
        double result = 4.5;

        result += overdraftCharge();

        return result;
    }

    private double overdraftCharge() {
        if (premium) {
            double result = 10;
            if (getDaysOverdrawn() > 7)
                result += (getDaysOverdrawn() - 7) * 1.0;
            return result;
        } else
            return getDaysOverdrawn() * 1.75;
    }

    public double overdraftFee() {
        if (premium) {
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

    public String getType() {
        return premium ? "premium" : "normal";
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

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String printCustomer() {
        return customer.getName() + " " + customer.getEmail();
    }
}