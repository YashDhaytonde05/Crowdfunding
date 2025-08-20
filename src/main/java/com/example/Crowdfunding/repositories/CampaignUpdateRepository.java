package com.example.Crowdfunding.repositories;

import com.example.Crowdfunding.entities.CampaignUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CampaignUpdateRepository extends JpaRepository<CampaignUpdate, Long> {
    List<CampaignUpdate> findByCampaignId(Long campaignId);
}