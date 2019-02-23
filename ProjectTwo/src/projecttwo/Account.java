/* Filename: Account.java
 * Author: Zachary Brandenburg
 * Date: 10 February 2019
 * Purpose: Defines the Account class
 */
package projecttwo;

import javafx.stage.Stage;
import java.text.DecimalFormat;

public class Account {

    // Formatter for formatting dollar amounts
    static DecimalFormat formatter = new DecimalFormat("$0.00");

    // Initialize final variables
    private final double SERVICE_FEE = 1.50;
    private final double WITHDRAW_INCREMENT = 20.00;
    // Initialize class variables
    private String accountName;
    private double accountValue;
    //Declare static variable for withdraw counts initialized to one for first withdraw
    private static int withdrawCount = 1;

    // Default constructor
    public Account(){
        accountValue = 0;
        accountName = "Account";
    } // end Account() constructor

    // Overloaded constructor accepting account initial value and account name
    public Account(double initialValue, String accountName) {
        this.accountValue = initialValue;
        this.accountName = accountName;
    } // end Account(double, String) constructor

    /* Method that transfers from this account to another account
     * Amount to be transferred must be less than account value else an exception is thrown
     */
    public void transferTo(double amount, Account account, Stage stage) throws InsufficientFundsException {

        if (amount <= accountValue) {
            this.accountValue -= amount;
            account.transferDeposit(amount);
            ProcessInput.popupDialog("Transferred " + formatter.format(amount)
                    + " to " + account.getAccountName(), stage);
        } else {
            throw new InsufficientFundsException("Insufficient Funds");
        }
    } // end transfer()

    /* Method that deducts an amount from the this accounts accountValue
     * Amount to be withdrawn must be less than account value else an exception is thrown
     * If all users accounts have more than 4 withdraws an service fee is applied to the transaction
     * All withdraws must be of the increment defined in WITHDRAW_INCREMENT variable
     */
    public void withdraw(double amount, Stage stage) throws InsufficientFundsException {
        // declare default messages for popups
        String withdrawMessage = "Withdrew " + formatter.format(amount);
        String serviceFeeMessage = "\nService fee of " + formatter.format(SERVICE_FEE) + " applied.";

        // declare and initialize variables
        boolean serviceFeeApplied = withdrawCount > 4;
        boolean amountGreaterThanZero = amount > 0;
        boolean correctIncrement = (int)amount % WITHDRAW_INCREMENT == 0;
        double deductionAmount = serviceFeeApplied ? amount + SERVICE_FEE : amount;
        boolean sufficientFunds = accountValue >= deductionAmount;

        // Throw exception if not sufficient funds
        if(!sufficientFunds) {
            throw new InsufficientFundsException("Insufficient Funds");
        }

        /*
         * sufficientFunds is no always true
         * If correct increment withdraw will process else system will display pop up dialog
        */
        if(correctIncrement && amountGreaterThanZero) {
            accountValue -= deductionAmount;
            withdrawCount++;
            ProcessInput.popupDialog(serviceFeeApplied ? withdrawMessage + serviceFeeMessage : withdrawMessage, stage);
        } else {
            ProcessInput.popupDialog("Please enter an increment of " +
                    formatter.format(WITHDRAW_INCREMENT), stage);
        }
    } // end withdraw()

    // Deposits funds into account by increasing account value and confirms with a popUp
    public void deposit(double amount, Stage stage) {
        accountValue += amount;
        ProcessInput.popupDialog("Deposited " + formatter.format(amount), stage);
    } // end deposit()

    public void transferDeposit(double amount) {
        accountValue += amount;
    } // end deposit()

    // Returns a String value of the accounts name and its current value
    public String balance() {
        return accountName + " Balance: " + formatter.format(accountValue);
    } // end balance()

    public String getAccountName() {
        return accountName;
    }

    @Override
    public String toString() {
        return "Account Name: " + accountName
            + "\nAccount Value: " + formatter.format(accountValue);
    } // end toString()
} // Account class