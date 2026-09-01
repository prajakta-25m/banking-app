package com.bank.bankingapp;

public class BankAccountResponse {
    private int accountNumber;
    private String accountName;
    private double balance;
     public int getAccountNumber(){
         return accountNumber;
     }
     public String getAccountName(){
         return  accountName;
     }
     public double getBalance(){
         return balance;
     }
     public void setAccountNumber(int accountNumber){
         this.accountNumber= accountNumber;
     }
     public void setAccountName(String accountName){
         this.accountName=accountName;
     }
     public void setBalance(double balance){
         this.balance=balance;
     }
}
