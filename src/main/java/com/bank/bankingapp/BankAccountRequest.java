package com.bank.bankingapp;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class BankAccountRequest {
    //used for validation thus helps that no user provides invalid data
    @Positive
    private int accountNumber;
    @NotNull
    private String accountName;
    @PositiveOrZero
    private double balance;

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountName(){
        return accountName;
    }
    public double getBalance(){
        return balance;
    }
    public void  setAccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    }
    public void setAccountName(String accountName){
        this.accountName=accountName;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
//hello practicing the github switch command
    // check uusing git branch
    // then when we want new  git branch type git switch -c
    //-c means create and then the name

}