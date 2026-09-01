package com.bank.bankingapp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController // this will handle the http request and provide the data as response
public class BankController {
    //now we create and object and the
    private final bankservice service;

    //response as we fetch the data from the user
    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<BankAccountResponse> getAccount(@PathVariable int accountNumber){
        BankAccountResponse ac = service.getAccount(accountNumber);

         return ResponseEntity.ok(ac);
    }


    public BankController(bankservice service){
        this.service=service;
    }
    //bankservice needs another object we need to we need to create that object again


    @GetMapping("/hello")
    public String hello(){
        return "hii my name is praju" ;
    }

    // request + reponse
    @PostMapping("/account")
    public ResponseEntity<BankAccountResponse> createAccount(@Valid @RequestBody BankAccountRequest account ){

       BankAccountResponse acc =  service.setAccount(account);
        return ResponseEntity.status(201).body(acc);
    }
    @PutMapping("/account/update/{AccountNumber}")
    public ResponseEntity<BankAccountResponse> UpdateAccount(@PathVariable int AccountNumber, @Valid @RequestBody BankAccountRequest  account){
        BankAccountResponse acc =  service.updateAccount(account);
        return ResponseEntity.ok(acc);


    }

    @DeleteMapping("/account/delete/{accountNumber}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int accountNumber){
        BankAccountResponse acc = service.getAccount(accountNumber);
            service.deleteAccount(accountNumber);
            return ResponseEntity.noContent().build();

    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFound(AccountNotFoundException e ){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validationError(MethodArgumentNotValidException e){
        Map<String , String> mpp = new HashMap<>();
        for(FieldError error:e.getBindingResult().getFieldErrors()){
            mpp.put(error.getField(),error.getDefaultMessage());
        }
//        mpp.put("AccountName" , "Must Not be null");
//        mpp.put("balance", "Must not be negative");
//        mpp.put("AccountNumber", "Must not be negative");
        return ResponseEntity.badRequest().body(mpp);
    }
    //@GetMapping("/balance")
   // public BankAccount getAccount(){
      //return service.getBalance();
    }


