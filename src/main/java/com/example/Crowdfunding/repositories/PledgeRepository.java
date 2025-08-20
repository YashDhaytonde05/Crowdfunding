package com.example.Crowdfunding.repositories;

import com.example.Crowdfunding.entities.Pledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PledgeRepository extends JpaRepository<Pledge, Long> {}
