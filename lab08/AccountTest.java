import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by hugh on 16/7/1.
 */
public class AccountTest {
    @org.junit.Test
    //check that the balance of a newly created account is the amount provided to the constructor.
    public void testInit() throws Exception {
        Account a = new Account(888);
        assertTrue(a.getBalance() == 888);
    }

    @Test
    //make sure that the result of supplying a negative number to deposit and withdraw doesn't change the account's balance
    public void testInvalidArgs() throws Exception {
        Account a = new Account(100);
        a.deposit(-10);
        assertTrue(a.getBalance() == 100);
        a.withdraw(-10);
        assertTrue(a.getBalance() == 100);
    }

    @Test
    //make sure that an attempt to withdraw more money than the account contains doesn't change the account's balance.
    public void testOverdraft() throws Exception {
        Account a = new Account(100);
        a.withdraw(101);
        assertTrue(a.getBalance() == 100);
    }

    @Test
    //make sure that the account balance reflects the result of a legal call to deposit.
    public void testDeposit() throws Exception {
        Account a = new Account(100);
        a.deposit(10);
        assertTrue(a.getBalance() == 110);
    }

    @Test
    //make sure that the account balance reflects the result of a legal call to withdraw.
    public void testWithdraw() throws Exception {
        Account a = new Account(100);
        a.withdraw(10);
        assertTrue(a.getBalance() == 90);
    }
}