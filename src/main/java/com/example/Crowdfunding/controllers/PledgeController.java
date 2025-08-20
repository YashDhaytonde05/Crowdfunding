package com.example.Crowdfunding.controllers;

import com.example.Crowdfunding.entities.Pledge;
import com.example.Crowdfunding.services.PledgeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/pledges")
public class PledgeController {
    @Autowired
    private PledgeService pledgeService;

    @PostMapping("/campaign/{campaignId}")
    public Pledge createPledge(@PathVariable Long campaignId, @RequestParam double amount) {
        return pledgeService.createPledge(campaignId, amount);
    }
}
