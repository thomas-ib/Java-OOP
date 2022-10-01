import java.util.Scanner;

interface Account {
    public void deposit(double amount);
    public void withdraw(double amount);
}

class BankAccount implements Account {

    private double balance;
    private int accountNumber;

    BankAccount(int accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    
    SavingsAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
        this.interestRate = 0.5;
    }

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}

public class Main {

    public static void printOption() {
        System.out.println("Please enter the number of the options below:");
        System.out.println("\t1: Check Balance");
        System.out.println("\t2: Deposit");
        System.out.println("\t3: Withdraw");
        System.out.println("\t4: Exit");
    }

    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(1, 10000.0);

        System.out.println("Welcome to Bank ATM!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printOption();
            
            int input = scanner.nextInt();
            if (input == 4) break;
            switch(input) {
                case 1:
                    System.out.printf("Balance: %f\n", savings.getBalance()); 
                    break;   
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double amount = scanner.nextDouble();
                    savings.deposit(amount);
                    System.out.printf("Balance: %f\n", savings.getBalance()); 
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    amount = scanner.nextDouble();
                    savings.withdraw(amount);
                    System.out.printf("Balance: %f\n", savings.getBalance()); 
                    break;
                default:
                    break;
            }
        } 
        scanner.close();
    }
}


