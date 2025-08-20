package com.example.Crowdfunding.services;

import com.example.Crowdfunding.entities.Campaign;
import com.example.Crowdfunding.repositories.CampaignRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import com.example.Crowdfunding.exceptions.ApiException;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    public Campaign createCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Optional<Campaign> getCampaignById(Long id) {
        return campaignRepository.findById(id);
    }

    public Page<Campaign> getPagedCampaigns(int page, int size) {
        return campaignRepository.findAll(PageRequest.of(page, size));
    }

    @PreAuthorize("hasRole('CREATOR')")
    public void deleteCampaignsByName(String title) {
        List<Campaign> campaigns = campaignRepository.findByTitle(title);
        if (campaigns.isEmpty()) {
            throw new ApiException("No campaign found with title: " + title);
        }
        campaignRepository.deleteAll(campaigns);
    }

    public List<Campaign> getCampaignsByName(String title) {
        return campaignRepository.findByTitle(title);
    }


    @PreAuthorize("hasRole('CREATOR') and @campaignSecurity.isOwner(#id)")
    public Campaign updateCampaign(Long id, Campaign updatedCampaign) {
        Campaign existing = campaignRepository.findById(id)
                .orElseThrow(() -> new ApiException("Campaign not found with id: " + id));


        existing.setTitle(updatedCampaign.getTitle());
        existing.setDescription(updatedCampaign.getDescription());
        existing.setGoalAmount(updatedCampaign.getGoalAmount());

        return campaignRepository.save(existing);
    }
}
