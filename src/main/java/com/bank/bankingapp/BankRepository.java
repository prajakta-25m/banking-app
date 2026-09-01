package com.bank.bankingapp;
import org.springframework.data.jpa.repository.JpaRepository;



//handle the fetching of data and providnig to the service
//ask the controller to create the object on its won no need to create and obj
//manage this class by urself
//extends = inheritance for classes," but Java also allows interface-to-interface inheritance using extends
public interface BankRepository extends JpaRepository<BankAccount,Integer> {







}//class responsible for getting the data  and will talk to real database
