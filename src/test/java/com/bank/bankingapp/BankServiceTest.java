package com.bank.bankingapp;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BankServiceTest {
// the repository is null
    @Mock
    BankRepository repository;
    bankservice service ;
    // now it actually creates a fake repository
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        service = new bankservice(repository);
    }

    // creates a fake repositoy
    // controller->service-> fake account


    @Test
    void shouldGetAccount(){

        BankAccount acc = new BankAccount(101,"Prajakta",2000);
        //when i find acc i say that Optional.of(acc) which means account is present rigth
        when(repository.findById(101)).thenReturn(Optional.of(acc));
        BankAccountResponse reponse = service.getAccount(101);
        assertEquals(101,reponse.getAccountNumber());
        assertEquals("Prajakta", reponse.getAccountName());
        assertEquals(2000,reponse.getBalance());
    }

    //makes sure that fake object is initialized before each test.

    @Test
    void shouldThrowExceptionWhenClassNotFound(){
        when(repository.findById(999)).thenReturn(Optional.empty());
        // it is checking if my account is actually throwing the error or not
        assertThrows(AccountNotFoundException.class, () -> {
            service.getAccount(999);
        });

    }

        @Test
        void howToSetAccount(){
            BankAccount acc = new BankAccount(102,"Rupa",3000);
            BankAccountRequest account =new BankAccountRequest();
            account.setAccountNumber(102);
            account.setAccountName("Rupa");
            account.setBalance(3000);
            when(repository.findById(102)).thenReturn(Optional.of(acc));
            service.setAccount(account);
            verify(repository).save(any(BankAccount.class));



    }
    @Test
    void updateTheAccount(){
        BankAccount acc = new BankAccount(103,"Raju",5000);
        BankAccountRequest account = new BankAccountRequest();
        account.setAccountName("Raju");
        account.setAccountNumber(103);
        account.setBalance(1000);
        when(repository.findById(103)).thenReturn(Optional.of(acc));
        service.updateAccount(account);
    }


}
