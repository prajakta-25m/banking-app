package com.bank.bankingapp;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
// determines and it has main busniess logic and fetch the data from repository
public class bankservice {
    private final BankRepository repository;


    public BankAccountResponse setAccount(BankAccountRequest account){
        BankAccount acc = new BankAccount();
        acc.setAccountNumber(account.getAccountNumber());
        acc.setName(account.getAccountName());
        acc.setBalance(account.getBalance());
        //it  has in inbuilt method to save to data
        repository.save(acc);
        int ac = account.getAccountNumber();
        BankAccountResponse rs = getAccount(ac);
        return rs ;
    }
    public bankservice(BankRepository repository) {
        this.repository = repository;
    }

    public BankAccountResponse getAccount(int accountNumber){
        //it has inbuilt method find by id
        Optional<BankAccount> account = repository.findById(accountNumber);
        BankAccountResponse accountResponse = new BankAccountResponse();
        if(account.isPresent()){
            BankAccount acc = account.get();
            accountResponse.setAccountNumber(acc.getAccountNumber());
            accountResponse.setAccountName(acc.getName());
            accountResponse.setBalance(acc.getBalance());
            return  accountResponse;
        }


        throw new AccountNotFoundException("Account not Found"+accountNumber);

    }

    public BankAccountResponse updateAccount(BankAccountRequest newAcc){
        BankAccount acc = new BankAccount();
        acc.setBalance(newAcc.getBalance());
        acc.setAccountNumber(newAcc.getAccountNumber());
        acc.setName(newAcc.getAccountName());
        repository.save(acc);
        int n = acc.getAccountNumber();
        BankAccountResponse rs = getAccount(n);
        return  rs;
    }
    public void deleteAccount(int AccountNumber){
        if(!repository.existsById(AccountNumber)){
            throw new AccountNotFoundException("Account not Found"+AccountNumber);
        }
        repository.deleteById(AccountNumber);
    }


   // public String getBalance(){
    //    return repository.getBalance();
    //}
}
