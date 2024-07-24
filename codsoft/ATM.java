package codesoft_intership;


	import java.util.Scanner;

	class Account {
	    private double bal;

	    public Account(double balance) {
	        this.bal = balance;
	    }

	    public boolean deposit(double depositAmount) {
	        if (depositAmount > 0) {
	            bal += depositAmount;
	            return true;
	        }
	        return false;
	    }

	    public boolean withdraw(double withdrawAmount) {
	        if (withdrawAmount > 0 && withdrawAmount <= bal) {
	            bal -= withdrawAmount;
	            return true;
	        }
	        return false;
	    }

	    public double checkBalance() {
	        return bal;
	    }
	}

	class Services {
	    private Account bankAccnt;

	    public Services(Account bankAccnt) {
	        this.bankAccnt = bankAccnt;
	    }

	    public void displayMenu() {
	        System.out.println("WELCOME TO ATM SERVICES:");
	        System.out.println("1. Withdraw");
	        System.out.println("2. Deposit");
	        System.out.println("3. Check Balance");
	        System.out.println("4. Exit");
	    }

	    public void userInterface() {
	        Scanner sc1 = new Scanner(System.in);

	        while (true) {
	            displayMenu();
	            System.out.print("Please select an option (1/2/3/4): ");
	            String choice = sc1.nextLine();

	            switch (choice) {
	                case "1":
	                    System.out.print("Enter withdrawal amount: ");
	                    double withdrawAmount = Double.parseDouble(sc1.nextLine());
	                    if (bankAccnt.withdraw(withdrawAmount)) {
	                        System.out.println("Withdrawal successful.");
	                    } else {
	                        System.out.println("Insufficient balance or invalid amount.");
	                    }
	                    break;

	                case "2":
	                    System.out.print("Enter deposit amount: ");
	                    double depositAmount = Double.parseDouble(sc1.nextLine());
	                    if (bankAccnt.deposit(depositAmount)) {
	                        System.out.println("Deposit successful.");
	                    } else {
	                        System.out.println("Invalid amount.");
	                    }
	                    break;

	                case "3":
	                    double balance = bankAccnt.checkBalance();
	                    System.out.println("Your current balance: $" + balance);
	                    break;

	                case "4":
	                    System.out.println("Thank you for using the ATM.");
	                    sc1.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Please select a valid option.");
	                    break;
	            }
	        }
	    }
	}

	public class ATM {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter initial account balance: ");
	        double initialBalance = Double.parseDouble(sc.nextLine());

	        Account userAccnt = new Account(initialBalance);
	        Services atm = new Services(userAccnt);
	        atm.userInterface();
	    }
	}



