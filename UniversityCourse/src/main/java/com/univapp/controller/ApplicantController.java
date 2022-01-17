package com.univapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.univapp.dao.ApplicantDAO;
import com.univapp.exception.ApplicantNotFoundException;
import com.univapp.model.*;


@RestController
@RequestMapping("/api/v1")
public class ApplicantController {
	
	@Autowired
	private ApplicantDAO appdao;
	
	
	
	//http://localhost:8093/applicant/Apply
	@PostMapping("/Apply")
	public String Apply() {
		
		
		List<Applicant> applicants = null;
		appdao.saveAll(applicants);
		return "Applied";

	}
	//save applicant details
	@PostMapping(path="/saveApply",consumes="application/json")
	public String saveApplicant(@RequestBody Applicant applicants){  
		
		appdao.save(applicants); 
		return "Applicant created Succesfully";
		
	} 
	
	@GetMapping("/getApplicant")
	public List<Applicant> getApplicant(){
		return (List<Applicant>) appdao.findAll();
	}
	@ResponseBody
	@GetMapping("/getapplicantStatus")
	public List<Applicant[]> getapplicantStatus(String applicantStatus){
		return appdao.getapplicantStatus(applicantStatus);
	}
	
	//update applicant details
	@PutMapping("/updateApplicant")
	public Applicant update(@RequestBody Applicant applicants)
	{
		return appdao.save(applicants);
	}	
	//delete applicant details using id
	@RequestMapping(value="/deleteApplicant//{id}",method = RequestMethod.DELETE)
	public void deleteApplicant(@PathVariable("id")int id)
	{
		appdao.deleteById(id);
	}
	
	//update applicant using applicant id
	@PutMapping("/updatebyid/{id}")
	public Applicant updateNote(@PathVariable(value = "id")Integer applicantId,@Valid @RequestBody Applicant applicantDetails)throws ApplicantNotFoundException
	{
		Applicant applicants;
		if(appdao.findById(applicantId).isEmpty())
		{
			throw new ApplicantNotFoundException("NO Applicant exist in id:"+applicantId);
		}
		else
		{
			applicants = appdao.findById(applicantId).get();
		}
		return applicants;
	}
		
}
	

