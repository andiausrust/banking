package andi.com;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount bankAccount;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("Executes before any ... count = " + count++);
    }

    @org.junit.Before
    public void setup() {
        bankAccount = new BankAccount("Tim", "Buchalka",
                1000, BankAccount.CHECKING);
        System.out.println("Running a test ...");
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception{
        double balance = bankAccount.withdraw(600, true);
        assertEquals(400, balance, 0);
    }

    // expected an Exception
   @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception{
        double balance = bankAccount.withdraw(600, false);
        assertEquals(400, balance, 0);
    }

    @org.junit.Test
    public void deposit() {
        double balance = bankAccount.deposit(200.00, true);
        assertEquals(1200, balance, 0);
    }

    @org.junit.Test
    public void getBalance_deposit() {
        bankAccount.deposit(200, true);
        assertEquals(1200, bankAccount.getBalance(), 0);
    }

   @org.junit.Test
    public void getBalance_withdraws() {
        bankAccount.withdraw(200, true);
        assertEquals(800, bankAccount.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true(){
        assertTrue("the account is not a checking account", bankAccount.isCHECKING());

    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println(" ... executes after any test. count =" + count++);

    }

    @org.junit.After
    public void after(){
        System.out.println("count= " + count++);
    }

}