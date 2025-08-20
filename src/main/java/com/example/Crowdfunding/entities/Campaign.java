package com.example.Crowdfunding.entities;

import com.example.Crowdfunding.entities.Pledge;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double goalAmount;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pledge> pledges;

    public Campaign() {}

    // Getter & Setter for all fields

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getGoalAmount() { return goalAmount; }
    public void setGoalAmount(double goalAmount) { this.goalAmount = goalAmount; }

    public List<Pledge> getPledges() { return pledges; }
    public void setPledges(List<Pledge> pledges) { this.pledges = pledges; }

    @Transient
    public double getPledgedAmount() {
        if (pledges == null) return 0;
        return pledges.stream().mapToDouble(Pledge::getAmount).sum();
    }

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }

}
