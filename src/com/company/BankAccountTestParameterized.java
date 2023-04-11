package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount account;

    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup(){
        account = new BankAccount("Tim","Buchalka",1000, BankAccount.CHECKING);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][]{
                {100,true,1100},
                {200,true,1200},
                {325.14,true,1325.14},
                {489.33,true,1489.33},
                {1000,true,2000}
        });
    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(amount,branch);
        assertEquals(expected,account.getBalance(),.01);
    }
}
