package Models;

public class Transactions {
    private int transactionsid;
    private int accountid;
    private int amount;

    public int getTransactionsid() {
        return transactionsid;
    }

    public void setTransactionsid(int transactionsid) {
        this.transactionsid = transactionsid;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Transactions(int transactionsid, int accountid, int amount) {
        this.transactionsid = transactionsid;
        this.accountid = accountid;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionsid=" + transactionsid +
                ", accountid=" + accountid +
                ", amount=" + amount +
                '}';
    }
}
