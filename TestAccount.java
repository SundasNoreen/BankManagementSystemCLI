//Assignment 2 by 2019-CE-3 (Sundas Noreen)

package Assignment2;
import java.util.*;

public class TestAccount
{
    public static void main(String[] args)
    {
    ArrayList <Account> accounts = new ArrayList<Account>();
        Scanner User = new Scanner(System.in);
        do {
            System.out.println("\nWelcome to Our System !! ");
            System.out.println("\n----------------------------------------------------------------------- ");
            System.out.println("\nAre you an Existing  User or New? ");
            System.out.println("Press 1 if you are a New User. ");
            System.out.println("Press 2 if you are an Existing User. ");
            System.out.println("Press 3 if you are an Admin. ");
            int Option = User.nextInt();
            if (Option == 1) {
                System.out.println("\nEnter Your Information to Get Your Account Registered: ");
                System.out.println("\n----------------------------------------------------------------------- ");
                System.out.print("Your Name: ");
                String accountTitle = User.next();
                System.out.print("Your Email: ");
                String emailID = User.next();
                System.out.print("The Balance You Want to Save as Opening Balance (Must be More than Rs.5000): ");
                double openingBal = User.nextDouble();
                if (openingBal >= 5000) {
                    if (emailID != null) {
                        System.out.println("\n----------------------------------------------------------------------- ");
                        Account MyObj = new Account(0, accountTitle, openingBal, emailID);
                        accounts.add(MyObj);
                        System.out.println("Your Account ID " + MyObj.getAccountId());
                        System.out.println("Your Account Title " + MyObj.getAccountTitle());
                        System.out.println("Your Email ID " + MyObj.getEmailID());
                        System.out.println("Your Opening Balance " + MyObj.getOpeningBal());
                    } else {
                        System.out.println("\n----------------------------------------------------------------------- ");
                        Account MyObj = new Account(0, accountTitle, openingBal);
                        System.out.println("Your Account ID " + MyObj.getAccountId());
                        System.out.println("Your Account Title " + MyObj.getAccountTitle());
                        System.out.println("Your Email ID " + MyObj.getEmailID());
                        System.out.println("Your Opening Balance " + MyObj.getOpeningBal());
                    }
                } else {
                    System.out.println("\nSorry, We are unable to proceed your request. Check the Information you provided and Try Again.");
                }
            }
            else if (Option == 2)
            {
                System.out.println("\nWelcome ");
                System.out.println("\nEnter Your Account ID: ");
                int accountID = User.nextInt();
                Account search = accounts.get(accountID - 1);
                System.out.println("Press 1 if you want to View Your Account Details. ");
                System.out.println("Press 2 if you are want to Deposit Money. ");
                System.out.println("Press 3 if you want to WithDraw Money. ");
                int Action = User.nextInt();
                if (Action == 1) {
                    System.out.println("Your Account ID: " + search.getAccountId());
                    System.out.println("Your Account Title: " + search.getAccountTitle());
                    System.out.println("Your Email ID: " + search.getEmailID());
                    System.out.println("Your Account Balance: " + search.getAccountBal());
                }
                else if (Action == 2) {
                    System.out.println("Enter the amount you want to Deposit: ");
                    double amount = User.nextInt();
                    search.deposit(amount);
                    accounts.set(accountID - 1, search);
                    System.out.println("Your Account Balance Now is: " + search.getAccountBal());
                }
                else if (Action == 3) {
                    System.out.println("Enter the amount you want to WithDraw: ");
                    double amount = User.nextInt();
                    if (search.withdraw(amount)) {
                        accounts.set(accountID - 1, search);
                    } else {
                        System.out.println("Sorry! Your Balance is Below Limit, We Cannot WithDraw.");
                    }
                    System.out.println("Your Account Balance Now is: " + search.getAccountBal());
                }
                else {
                System.out.println("Enter a Valid Choice.");
                }
            }
            else if (Option==3)
            {
                System.out.println("\nWelcome ");
                System.out.println("Press 1 if you want to View Number of Accounts. ");
                System.out.println("Press 2 if you  want to view Account IDs. ");
                System.out.println("Press 3 if you want to change Minimum Limit. ");
                int Value = User.nextInt();
                if (Value == 1)
                {
                    System.out.println("Total Number of Accounts Are: " + Account.getNumAccount());
                }
                else if (Value == 2)
                {
                    for (Account x : accounts)
                    {
                        Account search = x;
                        System.out.println(search.getAccountId()+"   "+search.getAccountTitle());
                    }
                }
                else if (Value==3)
                {
                    System.out.println("The Current Minimum Balance Limit is: "+Account.getMinBalLimit());
                    System.out.println("Enter the New Minimum Limit You Want to Set: ");
                    int new_limit = User.nextInt();
                    Account.setMinBalLimit(new_limit);
                    System.out.println("The New Minimum Balance Limit is: "+ Account.getMinBalLimit());
                }
                else
                {
                    System.out.println("Please Enter a Valid Choice.");
                }
            }
            else
            {
                System.out.println("Please Enter a Valid Choice.");
            }
                System.out.println("\n----------------------------------------------------------------------- ");
                System.out.println("\nDo you want to Continue? Type 'Yes' or 'No'");
                String option = User.nextLine();
            }
            while (User.nextLine().equalsIgnoreCase("Yes"));
            System.out.println("Thankyou");
        }
}
