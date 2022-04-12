import java.text.DecimalFormat;

public class TestBankAccount {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();

        DecimalFormat d = new DecimalFormat("'$'0.00");

        System.out.println("\nDepositing $200");
        account1.depositMoney(200, "checking");
        
        System.out.println("\nWithdrawing $50");
        account1.withdrawMoney(50, "checking");

        System.out.printf("Total Balance: %s\n", d.format(account1.getAccountBalance()));

        System.out.printf("Printing Account 1 Number: %s", account1.getAccountNumber());
    }
    



}
