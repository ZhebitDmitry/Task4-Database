package Models;

public class Account {
    private int accountid;
    private int userid;
    private int balance;
    private String currency;

    public Account(int accountid, int userid, int balance, String currency) {
        this.accountid = accountid;
        this.userid = userid;
        this.balance = balance;
        this.currency = currency;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountid=" + accountid +
                ", userid=" + userid +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
