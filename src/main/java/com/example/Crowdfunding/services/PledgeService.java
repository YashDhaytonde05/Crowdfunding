package com.example.Crowdfunding.services;

import com.example.Crowdfunding.entities.Campaign;
import com.example.Crowdfunding.entities.Pledge;
import com.example.Crowdfunding.repositories.CampaignRepository;
import com.example.Crowdfunding.repositories.PledgeRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PledgeService {
    @Autowired
    private PledgeRepository pledgeRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @PreAuthorize("hasRole('BACKER')")
    public Pledge createPledge(Long campaignId, double amount) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        if ((campaign.getPledgedAmount() + amount) > campaign.getGoalAmount()) {
            throw new RuntimeException("Pledge exceeds campaign goal");
        }

        Pledge pledge = new Pledge();
        pledge.setAmount(amount);
        pledge.setCampaign(campaign);

        return pledgeRepository.save(pledge);
    }
}
