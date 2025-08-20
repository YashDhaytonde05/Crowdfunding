// src/main/java/com/example/crowdfunding/security/CampaignSecurity.java

package com.example.Crowdfunding.security;

import com.example.Crowdfunding.entities.Campaign;
import com.example.Crowdfunding.entities.User;
import com.example.Crowdfunding.repositories.CampaignRepository;
import com.example.Crowdfunding.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("campaignSecurity")
public class CampaignSecurity {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean isOwner(Long campaignId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null)
            return false;
        String username = auth.getName();
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null)
            return false;
        Campaign campaign = campaignRepository.findById(campaignId).orElse(null);
        if (campaign == null)
            return false;
        return campaign.getOwner().getId().equals(user.getId());
    }
}
