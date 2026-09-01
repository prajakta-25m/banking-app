package com.bank.bankingapp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name="bank_account")
public class BankAccount {
    @Id// acts as a primary key
    @Positive
    @Column(name="account_number")
    private int AccountNumber;
    @Column(name="account_name")
    @NotBlank
    private String AccountName;
    @PositiveOrZero
    @Column(name="balance")
    private double balance;

    public BankAccount(int AccountNumber,String AccountName,double balance){
        this.AccountNumber=AccountNumber;
        this.AccountName=AccountName;
        this.balance=balance;

    }
    public BankAccount(){
        this(0,"unknow",0.0);
    }
    public int getAccountNumber(){
       return AccountNumber;
    }

    public String getName(){
        return AccountName;
    }

    public double getBalance(){
        return balance;
    }

    public void setName(String AccountName){
        this.AccountName= AccountName;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setAccountNumber(int accountNumber){
        this.AccountNumber=accountNumber;
    }



}
