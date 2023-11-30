package Com.BankingSystemPro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private String username;
    private String password;
    private String phoneNumber;
    private boolean isActive;
    private boolean isSavingsAccount;
    private String address;
    private String position;
    private double accountBalance;
    private List<String> transactionHistory;
    private static Map<String, Client> clientMap = new HashMap<>();
    public Client(String id, String firstName, String lastName, String accountNumber,
                  String username, String password, String phoneNumber, boolean isActive, boolean
                          isSavingsAccount, String address, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.isSavingsAccount = isSavingsAccount;
        this.address = address;
        this.position = position;
        this.accountBalance = 0.0;
        this.transactionHistory = new ArrayList<>();
// Add client object to the map for easy retrieval
        clientMap.put(accountNumber, this);
    }
    public void editPersonalInformation(String newAddress, String newPosition) {
        this.address = newAddress;
        this.position = newPosition;
    }
    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Username: " + username);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Account Status: " + (isActive ? "Active" : "Closed"));
        System.out.println("Account Type: " + (isSavingsAccount ? "Savings" :
                "Current"));
        System.out.println("Address: " + address);
        System.out.println("Position: " + position);
        System.out.println("Account Balance: " + accountBalance);
    }
    public void transferMoney(double amount, String receiverAccountNumber) {
        if (amount > accountBalance) {
            System.out.println("Insufficient balance. Transfer cannot be completed.");
            return;
        }
// Deduct amount from sender's account
        accountBalance -= amount;
        if (!isValidAccountNumber(receiverAccountNumber)) {
            System.out.println("Invalid receiver account number. Transfer cannot be completed.");
            return;
        }
        Client receiver = getClientByAccountNumber(receiverAccountNumber);
        if (receiver == null) {
            System.out.println("Receiver account not found. Transfer cannot be completed.");
            return;
        }
// Add amount to receiver's account
        receiver.accountBalance += amount;
// Add transaction to history
        String senderTransaction = "Transfer: -" + amount + " to account number " +
                receiverAccountNumber;
        String receiverTransaction = "Transfer: +" + amount + " from account number "
                + accountNumber;
        transactionHistory.add(senderTransaction);
        receiver.transactionHistory.add(receiverTransaction);
        System.out.println("Transfer of " + amount + " to account number " +
                receiverAccountNumber + " successful.");
    }
    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    public void takeDeposit(double amount) {
        accountBalance += amount;
        String transaction = "Deposit: +" + amount;
        transactionHistory.add(transaction);
        System.out.println("Taking a deposit of " + amount + " from the account");
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void updateAccountBalance(double newBalance) {
        this.accountBalance = newBalance;
    }
    private boolean isValidAccountNumber(String accountNumber) {
        return accountNumber.length() == 8;
    }
    private Client getClientByAccountNumber(String accountNumber) {
        return clientMap.get(accountNumber);
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}