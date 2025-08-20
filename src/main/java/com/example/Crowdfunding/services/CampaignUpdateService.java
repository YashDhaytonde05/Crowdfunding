package com.example.Crowdfunding.services;

import com.example.Crowdfunding.entities.CampaignUpdate;
import com.example.Crowdfunding.repositories.CampaignUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignUpdateService {
    @Autowired
    private CampaignUpdateRepository updateRepository;


    public CampaignUpdate saveUpdate(CampaignUpdate update) {
        update.setCreatedAt(java.time.LocalDateTime.now()); // Optional if not set by default
        return updateRepository.save(update);
    }

    public List<CampaignUpdate> getUpdatesForCampaign(Long campaignId) {
        return updateRepository.findByCampaignId(campaignId);
    }
}