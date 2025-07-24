package com.enzolfranco.projectPOO.repository;

import com.enzolfranco.projectPOO.exception.AccountNotFoundException;
import com.enzolfranco.projectPOO.exception.PixInUseException;
import com.enzolfranco.projectPOO.model.AccountWallet;
import com.enzolfranco.projectPOO.model.MoneyAudit;
import com.enzolfranco.projectPOO.model.Wallet;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.enzolfranco.projectPOO.repository.CommonsRepository.checkFundsForTransaction;
import static java.time.temporal.ChronoUnit.SECONDS;

public class AccountRepository {

    private List<AccountWallet> accounts;

    public AccountWallet create(final List<String> pix, final long initialFunds){
        AccountWallet newAccount = new AccountWallet(initialFunds, pix);
        accounts.add(newAccount);
        return newAccount;
    }

    public void deposit(final String pix, final long fundsAmount){
        AccountWallet target = findByPix(pix);
        target.addMoney(fundsAmount, "deposito");
    }

    public long withdraw(final String pix, final long amount){
        AccountWallet source = findByPix(pix);
        checkFundsForTransaction(source, amount);
        source.reduceMoney(amount);
        return amount;
    }

    public void transferMoney(final String sourcePix, final String targetPix, final long amount){
        AccountWallet source = findByPix(sourcePix);
        checkFundsForTransaction(source, amount);
        AccountWallet target = findByPix(targetPix);
        String message = "Pix enviado de " + sourcePix + " para " + targetPix;
        target.addMoney(source.reduceMoney(amount), source.getService(), message);
    }

    public AccountWallet findByPix(final String pix){
        return accounts.stream()
                .filter( a -> a.getPix().contains(pix))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("Chave pix: " + pix + " inexistente!"));
    }

    public List<AccountWallet> list(){
        return this.accounts;
    }

    public Map<OffsetDateTime, List<MoneyAudit>> getHistory(final String pix){
        Wallet wallet = findByPix(pix);
        List<MoneyAudit> audit = wallet.getFinancialTransactions();
        return audit.stream()
                .collect(Collectors.groupingBy(t -> t.createdAt().truncatedTo(SECONDS)));
    }

}
