import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account shukuraAccount;

    @BeforeEach
    void setUp() {
        shukuraAccount = new Account("Shukura", 1001, "1234");
    }

    @Test
    void newAccountHasZeroBalance() throws Exception {
        assertEquals(0, shukuraAccount.checkBalance("1234"));
    }

    @Test
    void deposit500BalanceShouldBe500() throws Exception {

        shukuraAccount.deposit(500);

        assertEquals(500, shukuraAccount.checkBalance("1234"));
    }

    @Test
    void withdraw200From500Leaves300() throws Exception {

        shukuraAccount.deposit(500);

        shukuraAccount.withdraw(200, "1234");

        assertEquals(300, shukuraAccount.checkBalance("1234"));
    }

    @Test
    void withdrawingTooMuchThrowsException() throws Exception {

        shukuraAccount.deposit(500);

        assertThrows(
                InsufficientFundsException.class,
                () -> shukuraAccount.withdraw(1000, "1234")
        );
    }

    @Test
    void depositNegativeThrowsException() {

        assertThrows(
                InvalidAmountException.class,
                () -> shukuraAccount.deposit(-10)
        );
    }

    @Test
    void withdrawNegativeThrowsException() {

        assertThrows(
                InvalidAmountException.class,
                () -> shukuraAccount.withdraw(-50, "1234")
        );
    }

    @Test
    void wrongPinThrowsException() {

        assertThrows(
                InvalidPinException.class,
                () -> shukuraAccount.checkBalance("9999")
        );
    }

    @Test
    void withdrawWithWrongPinThrowsException() throws Exception {

        shukuraAccount.deposit(500);

        assertThrows(
                InvalidPinException.class,
                () -> shukuraAccount.withdraw(100, "9999")
        );
    }
}