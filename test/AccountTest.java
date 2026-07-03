
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    private Account shukuraAccount;
    @BeforeEach
    public void setup(){
        shukuraAccount = new Account();
    }
    @Test
    public void deposit200inEmptyAccount_balanceIs200Test(){
        assertEquals(0, shukuraAccount.getBalance());

        shukuraAccount.deposit(200);
        assertEquals(200, shukuraAccount.getBalance());
    }
    @Test
    public void depositMinus50_balanceIsZeroTest(){
        assertEquals(0, shukuraAccount.getBalance());

        shukuraAccount.deposit(-50);
        assertEquals(0, shukuraAccount.getBalance());
    }
    @Test
    public void deposit_200_deposit_500_balanceIs700Test(){
        assertEquals(0, shukuraAccount.getBalance());

        shukuraAccount.deposit(200);
        shukuraAccount.deposit(500);
        assertEquals(700, shukuraAccount.getBalance());
    }
    @Test
    public void whenBalanceIsZero_withdraw50_balanceIsZeroTest(){
        assertEquals(0, shukuraAccount.getBalance());

        shukuraAccount.withdraw(50);
        assertEquals(0, shukuraAccount.getBalance());
    }
    @Test
    public void whenBalanceIs500_withdraw200_balanceIs300Test(){
        shukuraAccount.deposit(500);
        assertEquals(500, shukuraAccount.getBalance());

        shukuraAccount.withdraw(200);
        assertEquals(300, shukuraAccount.getBalance());
    }
    @Test
    public void whenBalanceIs500_withdraw1000_balanceIs500Test(){
        shukuraAccount.deposit(500);
        assertEquals(500, shukuraAccount.getBalance());

        shukuraAccount.withdraw(1000);
        assertEquals(500, shukuraAccount.getBalance());
    }

}
