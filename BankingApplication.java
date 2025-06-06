import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean validation;
        BankManagement bankManagement = new BankManagement();
        do {
            System.out.println("Welcome to the Library Catalog Management System!\n" +
                    "\n" +
                    "Please select an operation:\n" +
                    "1. Create bank account.\n" +
                    "2. View existing bank accounts details.\n" +
                    "3. Check account balance\n" +
                    "4. Deposit funds\n" +
                    "5. Withdraw funds");
            int operation = scanner.nextInt();
            String accountNumber;
            float amount;
            switch (operation){
                case 1:
                    System.out.println("Insert account number:");
                    accountNumber = scanner.next();
                    System.out.println("Insert account holder:");
                    String accountHolder = scanner.next();
                    BankAccount newBankAccount = new BankAccount();
                    newBankAccount.setAccountNumber(accountNumber);
                    newBankAccount.setAccountHolder(accountHolder);
                    newBankAccount.setBalance(0);
                    bankManagement.createBankAccount(newBankAccount);
                    break;
                case 2:
                    bankManagement.displayBankAccounts();
                    break;
                case 3:
                    System.out.println("Insert account number");
                    accountNumber = scanner.next();
                    bankManagement.checkBalance(accountNumber);
                    break;
                case 4:
                    System.out.println("Insert account number");
                    accountNumber = scanner.next();
                    System.out.println("Insert amount to deposit");
                    amount = scanner.nextFloat();
                    bankManagement.depositFunds(accountNumber,amount);
                    break;
                case 5:
                    System.out.println("Insert account number");
                    accountNumber = scanner.next();
                    System.out.println("Insert amount to withdraw");
                    amount = scanner.nextFloat();
                    bankManagement.withdrawingFunds(accountNumber,amount);
                    break;
                default:
                    System.out.println("Invalid output");
                    break;
            }
            System.out.println("Do you want to make another operation? (y/n)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("y")) {
                validation = true;
            } else if (answer.equalsIgnoreCase("n")) {
                validation = false;
            } else {
                System.out.println("Invalid input");
                validation = false;
            }
        } while (validation);
    }
}
