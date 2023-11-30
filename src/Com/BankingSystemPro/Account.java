package Com.BankingSystemPro;

public abstract class Account {

    private float accountNumber;
    private float senderAccount;
    private float receiverAccount;

    private float amount;
    public Account() {
    }

    public Account (float accountNumber, float senderAccount, float receiverAccount, float amount) {
        this.accountNumber = accountNumber;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
    }
    abstract void calculateInterest();
    abstract void checkMinimumBalance();
}
