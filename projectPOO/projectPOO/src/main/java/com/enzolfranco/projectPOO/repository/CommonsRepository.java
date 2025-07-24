package com.enzolfranco.projectPOO.repository;

import com.enzolfranco.projectPOO.model.AccountWallet;
import com.enzolfranco.projectPOO.exception.NoFundsEnoughException;
import com.enzolfranco.projectPOO.model.Money;
import com.enzolfranco.projectPOO.model.MoneyAudit;
import com.enzolfranco.projectPOO.model.Wallet;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static com.enzolfranco.projectPOO.model.BankService.ACCOUNT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonsRepository {

    public static void checkFundsForTransaction(final Wallet source, final long amount){
        if(source.getFunds() < amount){
            throw new NoFundsEnoughException("Sem fundos suficientes para essa transação!");
        }
    }

    public static List<Money> generateMoney(final UUID transactionId, final long funds, final String description){
        MoneyAudit history = new MoneyAudit(transactionId, ACCOUNT, description, OffsetDateTime.now());
        return Stream.generate(() -> new Money(history)).limit(funds).toList();
    }

}
