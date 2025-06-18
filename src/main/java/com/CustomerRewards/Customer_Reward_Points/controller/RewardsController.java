package com.CustomerRewards.Customer_Reward_Points.controller;


import com.CustomerRewards.Customer_Reward_Points.model.RewardResponse;
import com.CustomerRewards.Customer_Reward_Points.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for handling reward point requests.
 * */

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    /**
     * Endpoint to get reward points for all the customers.
     * @return list of reward Summaries.
     * */
    @GetMapping
    public List<RewardResponse> getRewards(){
        return rewardsService.calculateRewards();
    }


}
