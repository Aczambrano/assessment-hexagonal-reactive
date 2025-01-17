package ec.com.sofka.strategy;



import ec.com.sofka.Account;
import ec.com.sofka.ConflictException;

import java.math.BigDecimal;

public class PhysicalPurchaseStrategy implements TransaccionStrategy {
    private static final BigDecimal COSTO = BigDecimal.ZERO;

    @Override
    public void validate(Account account, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ConflictException("The amount for a physical purchase must be greater than 0.");
        }

        if (account.getBalance().compareTo(amount) < 0) {
            throw new ConflictException("Insufficient balance to make the physical purchase.");
        }

    }

    @Override
    public BigDecimal getAmount() {
        return COSTO;
    }
}

