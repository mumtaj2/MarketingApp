package com.marketingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp.Entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
