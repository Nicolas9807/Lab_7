package sample;

/**
 * @author Stolyar Mykola
 */
public class CompanyCustomer extends AbstractCustomer {
    private double companyOverdraftDiscount;

    public CompanyCustomer(String name, String email, Account account, double companyOverdraftDiscount) {
        super(name, email, account, CustomerType.COMPANY);
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public double getCompanyOverdraftDiscount() {
        return companyOverdraftDiscount;
    }

    public void setCompanyOverdraftDiscount(double companyOverdraftDiscount) {
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    @Override
    public double getOverdraftDiscount() {
        return companyOverdraftDiscount / (getAccount().isPremium() ? 2 : 1);
    }
}
