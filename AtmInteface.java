import java.util.*;

// Interface for Atm which has declaration for the required methods
interface Atm {
    public void withdraw(int amount, int choice);
    public void deposit(int amount, int choice);
    public void checkBalance();
}

// User class will implement the methods declared in ATM interface
class User implements Atm{
    // Local variables
    private int balance, atmPin;
    public String userName;

    // Defining constants
    public static final int MIN_BALANCE = 2000;
    public static final int WITHDRAWAL_LIMIT = 20000;

    Scanner sc = new Scanner(System.in);

    // Constructor
    User(int balance, String userName, int atmPin) {
        this.balance = balance;
        this.userName = userName;
        this.atmPin = atmPin;
    }

    // Choice 1: Withdraw
    public void withdraw(int amount, int choice) {
        System.out.println("Press Y/y to confirm withdrawal: ");
        char confirm = sc.next().toLowerCase().charAt(0);
        
        // Confirm if user wants to withdraw or not
        if (confirm != 'y')
        return;
        
        int validAmount = validateAmount(amount);
        // Check if user has sufficient balance
        if(validAmount == 1) {
            System.out.println("\nInsufficient balance in account!\n");
            return;
        }
        
        // Check if
        else if(validAmount == 2) {
            System.out.println("\nCannot withdraw more than Rs. 20000/-!\n");
            return;
        }
        
        // Update the account balance and display it to user;
        this.balance -= amount;
        System.out.println("\nAmount of Rs. " + amount + "/- withdrawn successfully...");
        this.checkBalance();
    }
    
    // Choice 2: Deposit
    public void deposit(int amount, int choice) {
        System.out.println("Press Y/y to confirm deposit: ");
        char confirm = sc.next().toLowerCase().charAt(0);
        
        // Confirm if user wants to deposit or not
        if (confirm != 'y')
        return;
        
        // Update the account balance and display it to user;
        this.balance += amount;
        System.out.println("\nAmount of Rs. " + amount + "/- deposited successfully...");
        this.checkBalance();
    }
    
    // Choice 3: Check account balance
    public void checkBalance() {
        System.out.println("\nYour account balance is: Rs. " + this.balance + "/-\n");
    }
    
    public boolean validatePin(int pin) {
        // Check if the pin is valid
        return (this.atmPin == pin);
    }
    
    private int validateAmount(int amount) {
        // Check if balance is insufficient or limit is exceeded
        if ((this.balance - amount) <= MIN_BALANCE)
        return 1;

        else if (amount > WITHDRAWAL_LIMIT) {
            return 2;
        }
        
        return 0;
    }
}

public class AtmInteface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User(5000, "vaibhav", 1334);
        
        // Take pin as input from user and validate it
        System.out.println("\n\t\tATM MACHINE\n");
        System.out.println("Enter the 4 digit pin to continue: ");
        int pin = sc.nextInt();
        boolean valid = user.validatePin(pin);
        
        if (!valid){
            sc.close();
            return;
        }

        while (true) {
            // Take the choice of user from input
            System.out.println("\n=============================================");
            System.out.println("\n\t\tMENU\n");
            System.out.println("1: Withdraw amount");
            System.out.println("2: Deposit amount");
            System.out.println("3: Check account balance");
            System.out.println("4: Exit\n");
            System.out.println("\n=============================================\n");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();  
            
            int amount;
            switch (choice) {
                case 1:
                    // Display balance before withdrawing
                    user.checkBalance();
                    System.out.print("Enter the amount to be withdrawn: \n");
                    amount = sc.nextInt();
                    user.withdraw(amount, choice);
                    break;
                    
                case 2: 
                    // Display balance before withdrawing
                    user.checkBalance();
                    System.out.print("Enter the amount to be deposited: \n");
                    amount = sc.nextInt();
                    user.deposit(amount, choice);
                    break;

                case 3:     
                    user.checkBalance();
                    break;

                case 4: 
                    break;

                default:
                    System.out.println("Please enter a valid choice!");
            }
            if(choice == 4) 
                break;
        }
        
        sc.close();
    }
}
