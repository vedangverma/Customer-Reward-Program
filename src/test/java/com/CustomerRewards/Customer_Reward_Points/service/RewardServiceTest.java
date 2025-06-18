package com.CustomerRewards.Customer_Reward_Points.service;


import com.CustomerRewards.Customer_Reward_Points.model.RewardResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit tests for reward service
 * */

public class RewardServiceTest {

    @Test
    public void testCalculateRewards(){
        RewardsService service = new RewardsService();
        List<RewardResponse> rewards = service.calculateRewards();

        assertFalse(rewards.isEmpty(),"Rewards list should not be empty");
        assertTrue(rewards.stream().anyMatch(r->r.getTotalPoints()>0), "At Leaast one customer should have points");

    }

}
