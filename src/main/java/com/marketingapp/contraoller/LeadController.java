package com.marketingapp.contraoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.Entities.Lead;
import com.marketingapp.dto.LeadDto;
import com.marketingapp.service.LeadService;
import com.marketingapp.utility.EmailService;



@Controller
public class LeadController {

	@Autowired	
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	//http://localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLead() {
		return "create_lead";
	
}	                                           // first method 
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute Lead lead, Model Model) {
		
	
			leadService.saveLead(lead);
			emailService.sendEmail(lead.getEmail(), "Test", "welcome to data");
			Model.addAttribute("msg", "gmail will updated!!");
			
			return "create_lead";

	}
	                                          //Second method
//	@RequestMapping("/saveLead")      //you use create then stop and run data delete  
//	public String saveLead(
//			@RequestParam("firstname")String firstname,
//			@RequestParam("lastname")String lastname,
//			@RequestParam("email")String email,
//			@RequestParam("mobile")long mobile
//			){
//		Lead lead= new Lead();
//		lead.setFirstname(firstname);
//		lead.setLastname(lastname);
//		lead.setEmail(email);
//		lead.setMobile(mobile);		
//		
//			leadService.saveLead(lead);
//			return "create_lead";
//
//	}
	                                            //third method
//	@RequestMapping("/saveLead")
//	public String saveLead(LeadDto leadDto) {
//		Lead lead= new Lead();
//			lead.setFirstname(leadDto.getFirstname());
//			lead.setLastname(leadDto.getLastname());
//			lead.setEmail(leadDto.getEmail());
//			lead.setMobile(leadDto.getMobile());
//			leadService.saveLead(lead);
//			return "create_lead";
//
//	}
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String getAllLeads(Model model ) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "search_result";
		
	}
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id") long id,Model model) {
		leadService.deleteLeadbyId(id);
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "search_result";
	}
	@RequestMapping("/update")
	public String getLeadById(@RequestParam("id") long id,Model model) {
		Lead lead =leadService.findLeadById(id);
		model.addAttribute("Lead", lead);
		return "update_lead";
	}
	@RequestMapping("/updateLead")
	public String updateLead(LeadDto dto, Model model) {
		Lead l = new Lead();
		l.setId(dto.getId());
		l.setFirstname(dto.getFirstname());
		l.setLastname(dto.getLastname());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		
		leadService.saveLead(l);
	
	List<Lead> leads = leadService.getAllLeads();
	model.addAttribute("leads", leads);
	return "search_result";
	}
}
		

