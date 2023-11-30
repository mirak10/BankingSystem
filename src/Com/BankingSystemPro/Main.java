package Com.BankingSystemPro;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Client client1 = new Client("ID001", "John", "Doe", "AC001", "johnDoe", "password1", "123456789", true, true, "123 Main St", "Manager");
        Client client2 = new Client("ID002", "Jane", "Smith", "AC002", "janeSmith", "password2", "987654321", true, false, "456 Oak St", "Employee");


        System.out.println("Account details for client 1:");
        client1.displayAccountDetails();

        System.out.println("\nAccount details for client 2:");
        client2.displayAccountDetails();

        client1.editPersonalInformation("456 Pine St", "Senior Manager");


        System.out.println("\nUpdated account details for client 1:");
        client1.displayAccountDetails();


        client1.transferMoney(200.0, "AC002");


        System.out.println("\nUpdated account details for client 1:");
        client1.displayAccountDetails();

        System.out.println("\nUpdated account details for client 2:");
        client2.displayAccountDetails();


        System.out.println("\nTransaction history for client 1:");
        client1.showTransactionHistory();


        client2.takeDeposit(100.0);


        System.out.println("\nUpdated account details for client 2:");
        client2.displayAccountDetails();

    }

}

