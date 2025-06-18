package com.CustomerRewards.Customer_Reward_Points.service;


import com.CustomerRewards.Customer_Reward_Points.exception.InvalidTransactionException;
import com.CustomerRewards.Customer_Reward_Points.model.RewardResponse;
import com.CustomerRewards.Customer_Reward_Points.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service class to calculate reward points per transaction and month.
 * */
@Service
public class RewardsService {

    // Mock transaction data
    private List<Transaction> transactions = Arrays.asList(
            new Transaction("Rohit",120, LocalDate.of(2025,1,15)),
            new Transaction("Rohit",75, LocalDate.of(2025,2,10)),
            new Transaction("Vedang",200, LocalDate.of(2025,1,5)),
            new Transaction("Vedang",50, LocalDate.of(2025,3,20)),
            new Transaction("Sharan",130, LocalDate.of(2025,3,25))
    );
    public List<RewardResponse> calculateRewards(){
        Map<String, Map<String, Integer>> customerMonthlyPoints = new HashMap<>();

        for(Transaction tx: transactions){
            int points = calculatePoints(tx.getAmount());
            String month = tx.getDate().getMonth().toString();
            customerMonthlyPoints.computeIfAbsent(tx.getCustomerId(), k-> new HashMap<>()).merge(month,points,Integer::sum);
            if(tx.getAmount() < 0){
                throw new InvalidTransactionException("Transaction amount cannot be negative: " + tx.getAmount());
            }
        }
        return customerMonthlyPoints.entrySet().stream().map(entry -> {
            int total  = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            return new RewardResponse(entry.getKey(),entry.getValue(),total);
        }).collect(Collectors.toList());
    }

    private int calculatePoints(double amount){
        int points = 0;



        if(amount > 100){
            points+=(int)((amount-100)*2);
            points+=50;
        }else if(amount > 50){
            points +=(int)(amount - 50);
        }
        return points;
    }

}
