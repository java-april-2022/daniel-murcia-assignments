import java.util.Random;
import java.lang.StringBuilder;

public class BankAccount {
    private double checking;
    private double savings;
    private String accountNumber;

    //Generate Random Account Number:
    private String generateAccountNum(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        String newAccountNum = "";
        for (int i = 0; i < 10; i++) {
            sb.append(String.valueOf(rand.nextInt(10)));
        }
        newAccountNum = sb.toString();
        return newAccountNum;
    }

    //Constructor: 

    public BankAccount(){
        noOfAccounts++;
        this.accountNumber = generateAccountNum();
    }

    //Static Methods for #ofAccounts & TotalBalancePerAccount:
    private static int noOfAccounts; 

    private static int getnoOfAccounts(){
        return noOfAccounts;
    }

    private static double totalMoneyPerAccount;


    //Accessors: 
    public double getChecking() {
        return checking;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getSavings() {
        return savings;
    }


    //Deposit Money Method:
    public void depositMoney(double amt, String account){
        if(account.equals("checking")){
            checking+= amt;
        }
        else if (account.equals("savings")) {
            savings+= amt;
        }
        totalMoneyPerAccount+= amt;
    }

    //Withdraw Money Method:
    public void withdrawMoney(double amt, String account){
        if(account.equals("checking")){
            checking-= amt;
        }
        else if (account.equals("savings")) {
            savings-= amt;
        }
        else if (savings==0){
            System.out.println("Insufficient Funds");
        }
        else if (checking==0){
            System.out.println("Insufficient Funds");
        }
        totalMoneyPerAccount-= amt;
    }

    //Get total account balance method: 
    public double getAccountBalance(){
        return totalMoneyPerAccount;
    }
}
