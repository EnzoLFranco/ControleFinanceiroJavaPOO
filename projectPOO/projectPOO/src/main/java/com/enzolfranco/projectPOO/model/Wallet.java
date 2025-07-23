package com.enzolfranco.projectPOO.model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public abstract class Wallet {

    @Getter
    private final BankService serviceType;

    protected final List<Money> money;

    public Wallet(BankService serviceType) {
        this.serviceType = serviceType;
        this.money = new ArrayList<>();
    }
}
