package com.example.Crowdfunding.controllers;

import com.example.Crowdfunding.entities.Campaign;
import com.example.Crowdfunding.entities.CampaignUpdate;
import com.example.Crowdfunding.repositories.CampaignRepository;
import com.example.Crowdfunding.services.CampaignService;
import com.example.Crowdfunding.services.CampaignUpdateService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;
    @Autowired
    private CampaignUpdateService updateService;
    @Autowired
    private CampaignRepository campaignRepository;

    @PostMapping
    public Campaign createCampaign(@RequestBody Campaign campaign) {
        return campaignService.createCampaign(campaign);
    }

    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    public Campaign getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
    }

    @PostMapping("/{campaignId}/updates")
    public CampaignUpdate addUpdate(
            @PathVariable Long campaignId,
            @RequestBody CampaignUpdate update) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
        update.setCampaign(campaign);
        return updateService.saveUpdate(update);
    }

    @GetMapping("/{campaignId}/updates")
    public List<CampaignUpdate> getUpdates(@PathVariable Long campaignId) {
        return updateService.getUpdatesForCampaign(campaignId);
    }

    @GetMapping("/paged")
    public Page<Campaign> getPagedCampaigns(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return campaignService.getPagedCampaigns(page, size);
    }

    @GetMapping("/by-name")
    public List<Campaign> getCampaignsByName(@RequestParam String title) {
        return campaignService.getCampaignsByName(title);
    }

    @DeleteMapping("/by-name")
    public ResponseEntity<String> deleteCampaignByName(@RequestParam String title) {
        campaignService.deleteCampaignsByName(title);
        return ResponseEntity.ok("Deleted campaign(s) with title: " + title);
    }

    @PutMapping("/{id}")
    public Campaign editCampaign(@PathVariable Long id, @RequestBody Campaign updatedCampaign) {
        return campaignService.updateCampaign(id, updatedCampaign);
    }

}
