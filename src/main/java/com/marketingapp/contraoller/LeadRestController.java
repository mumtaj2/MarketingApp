package com.marketingapp.contraoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.Entities.Lead;
import com.marketingapp.dto.LeadDto;
import com.marketingapp.repositories.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	@Autowired
	private LeadRepository leadsRepo;
	
	//http://localhost:9090/api/leads
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadsRepo.findAll();
		return leads;
	}
	@PostMapping
	public void createLead(@RequestBody Lead lead) {
		leadsRepo.save(lead);
	}
	//http://localhost:9090/api/leads/1
	@DeleteMapping("/{id}")
	public void deleteLead(@PathVariable("id") long id) {
		leadsRepo.deleteById(id);
		
	}
	//http://localhost:9090/api/leads/1
	@PutMapping("/{id}")
	public void updateLead(@RequestBody LeadDto dto,@PathVariable("id") long id) { 
	Lead l=new Lead();
	l.setId(id);
	l.setFirstname(dto.getFirstname());
	l.setLastname(dto.getLastname());
	l.setEmail(dto.getEmail());
	l.setMobile(dto.getMobile());
		leadsRepo.save(l);
	
	
	}
}
