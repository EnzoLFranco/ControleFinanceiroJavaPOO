package com.enzolfranco.projectPOO.model;

import lombok.Getter;
import lombok.ToString;

@ToString
public abstract class Wallet {

    @Getter
    private final BankService serviceType;

    

}
