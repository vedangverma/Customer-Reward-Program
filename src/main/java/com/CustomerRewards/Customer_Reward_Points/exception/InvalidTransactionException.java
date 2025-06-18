package com.CustomerRewards.Customer_Reward_Points.exception;

/**
 * Custom exception for invalid transaction.
 */
public class InvalidTransactionException extends RuntimeException {

    public InvalidTransactionException(String message){
        super(message);
    }


}
