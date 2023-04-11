package com.company;

import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before any test cases");
    }

    @org.junit.Before
    public void setUp(){
        account = new BankAccount("John","Doe",1000, BankAccount.CHECKING);
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200,true);
        assertEquals(1200,balance,0);
    }


    @org.junit.Test
    public void withdraw_branch() {
        double balance = account.withdraw(600,true);
        assertEquals(400,balance,0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch(){
        account.withdraw(600,false);
        fail("Should throw IllegalArgumentException");
    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200,true);
        assertEquals(1200,account.getBalance(),0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200,true);
        assertEquals(800,account.getBalance(),0);
    }

    @org.junit.Test
    public void isChecking_true(){
        boolean isChecking = account.isChecking();
        assertTrue("The account is NOT a checking account",isChecking);
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("This executes after all tests");
    }

}