import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BankManagement {
    HashMap<String,BankAccount> bankAccounts = new HashMap<>();

    public HashMap<String,BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(HashMap<String,BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public void checkBalance(String accountNumber){
        HashMap<String,BankAccount> bankAccounts = getBankAccounts();
        System.out.println("The account balance of the bank account " + accountNumber + " is " + bankAccounts.get(accountNumber).getBalance());
    }

    public void depositFunds(String accountNumber, float funds){
        try{
            HashMap<String,BankAccount> bankAccounts = getBankAccounts();
            if (bankAccounts.containsKey(accountNumber)){
                if (funds > 0){
                    float balance = bankAccounts.get(accountNumber).getBalance();
                    float newBalance = balance + funds;
                    bankAccounts.get(accountNumber).setBalance(newBalance);
                    setBankAccounts(bankAccounts);
                    System.out.println("Funds deposited");
                } else {
                    throw new InvalidAmountException("Invalid amount");
                }
            } else {
                System.out.println("Bank account not registered");
            }
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdrawingFunds(String accountNumber, float funds){
        try{
            HashMap<String,BankAccount> bankAccounts = getBankAccounts();
            if (bankAccounts.containsKey(accountNumber)){
                if (funds > 0){
                    float balance = bankAccounts.get(accountNumber).getBalance();
                    float newBalance = balance - funds;
                    if(newBalance >= 0){
                        bankAccounts.get(accountNumber).setBalance(newBalance);
                        setBankAccounts(bankAccounts);
                        System.out.println("Funds withdrawn");
                    } else {
                        throw new InsufficientFundsException("Insufficient funds");
                    }
                } else {
                    throw new InvalidAmountException("Invalid amount");
                }
            } else {
                System.out.println("Bank account not registered");
            }
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createBankAccount(BankAccount bankAccount){
        HashMap<String,BankAccount> bankAccounts = getBankAccounts();
        if(bankAccounts!=null){
            if(bankAccounts.isEmpty()){
                bankAccounts.put(bankAccount.getAccountNumber(),bankAccount);
                setBankAccounts(bankAccounts);
                System.out.println("Bank account added");
            } else {
                if (bankAccounts.containsKey(bankAccount.getAccountNumber())){
                    System.out.println("bank account already exist");
                } else {
                    bankAccounts.put(bankAccount.getAccountNumber(),bankAccount);
                    setBankAccounts(bankAccounts);
                    System.out.println("Bank account added");
                }
            }
        } else {
            bankAccounts = new HashMap<>();
            bankAccounts.put(bankAccount.getAccountNumber(),bankAccount);
            setBankAccounts(bankAccounts);
            System.out.println("Bank account added");
        }
    }

    public void displayBankAccounts(){
        HashMap<String,BankAccount> bankAccounts = getBankAccounts();
        for (String bankAccountKey : bankAccounts.keySet()){
            BankAccount bankAccount = bankAccounts.get(bankAccountKey);
            System.out.println("Bank number: " + bankAccount.getAccountNumber() + "\nAccount holder: " + bankAccount.getAccountHolder() + "\nBalance: " + bankAccount.getBalance() + "\n");
        }
    }
}

class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException (String message) {
        super(message);
    }
}

class InvalidAmountException extends RuntimeException {
    public InvalidAmountException (String message) {
        super(message);
    }
}
